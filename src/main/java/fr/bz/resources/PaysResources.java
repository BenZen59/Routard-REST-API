package fr.bz.resources;

import fr.bz.dto.InformerDto;
import fr.bz.dto.PaysDto;
import fr.bz.dto.SubdivisionDto;
import fr.bz.entities.*;
import fr.bz.repositories.InformerRepository;
import fr.bz.repositories.PaysRepository;
import fr.bz.repositories.SubdivisionRepository;
import fr.bz.repositories.TypeInfoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/pays/")
@Tag(name = "Pays")

public class PaysResources {
    @Inject
    private PaysRepository paysRepository;
    @Inject
    private SubdivisionRepository subdivisionRepository;

    @Inject
    private TypeInfoRepository typeInfoRepository;

    @Inject
    private InformerRepository informerRepository;

    @GET
    public Response getAll() {
        List<PaysEntity> paysEntities = paysRepository.listAll();
        return Response.ok(PaysDto.toDtoList(paysEntities)).build();
    }
    @GET
    @Path("{codeIso31661}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Pays par Id", description = "Chercher les pays par id")
    @APIResponse(responseCode = "200", description = "Ok, pays trouvé")
    @APIResponse(responseCode = "404", description = "Pays non trouvé")
    public Response getById(@PathParam("codeIso31661") String codeIso31661) {
        PaysEntity pays = paysRepository.findById(codeIso31661);
        if (pays == null) {
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("Ce code de pays n'existe pas !").build();
        }
        PaysDto paysByIdDto = new PaysDto(pays);
        return Response.ok(paysByIdDto).build();
    }

    @GET
    @Path("{codeIso31661}/subdivisions")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Obtenir subdivisions", description = "Obtenir les subdivisions d'un pays via le code iso 3166_1 du pays")
    @APIResponse(responseCode = "200", description = "Ok, subdivions trouvées")
    @APIResponse(responseCode = "404", description = "Subdivisions non trouvées")
    public Response getSubdivisionsByPays(@PathParam("codeIso31661") String codeIso31661) {
        List<SubdivisionEntity> subdivisionEntities = subdivisionRepository.findByPaysCodePays(codeIso31661);
        if (subdivisionEntities == null || subdivisionEntities.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("Aucune subdivisions trouvés pour ce pays").build();
        }
        List<SubdivisionDto> subdivisionByPaysDtoList = SubdivisionDto.toDtoList(subdivisionEntities);
        return Response.ok(subdivisionByPaysDtoList).build();
    }

    @GET
    @Path("{codeIso31661}/informations")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Obtenir informations", description = "Obtenir les informations d'un pays via le code iso 3166_1 du pays")
    @APIResponse(responseCode = "200", description = "Ok, informations trouvées")
    @APIResponse(responseCode = "404", description = "Informations non trouvées")
    public Response getInformationByPays(@PathParam("codeIso31661") String codeIso31661, @QueryParam("idTypeInfo") int idTypeInfo) {
        PaysEntity foundPays = paysRepository.findById(codeIso31661);
        TypeInfoEntity foundTypeInfo = typeInfoRepository.findById(idTypeInfo);
        List<InformerEntity> information = informerRepository.findInformationByPays(codeIso31661);
        if (foundPays == null) {
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("Cet id de pays n'existe pas !").build();
        }

        if (foundTypeInfo == null && idTypeInfo != 0) {
            return Response.status(Response.Status.NOT_FOUND)
                    .type(MediaType.TEXT_PLAIN)
                    .entity("L'id de type d'info n'existe pas")
                    .build();
        }
        if (foundTypeInfo != null) {
            information = informerRepository.findInformationByPaysAndTypeInfo(codeIso31661, idTypeInfo);
        }
        if (information.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .type(MediaType.TEXT_PLAIN)
                    .entity("Pas d'information pour ce pays")
                    .build();
        }
        List<InformerDto> informerDtoList = InformerDto.toDtoList(information);
        return Response.ok(informerDtoList).build();
    }
}
