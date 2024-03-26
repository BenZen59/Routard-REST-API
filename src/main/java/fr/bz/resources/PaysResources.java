package fr.bz.resources;

import fr.bz.dto.PaysByIdDto;
import fr.bz.dto.SubdivisionDto;
import fr.bz.entities.PaysEntity;
import fr.bz.entities.SubdivisionEntity;
import fr.bz.repositories.PaysRepository;
import fr.bz.repositories.SubdivisionRepository;
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
        PaysByIdDto paysByIdDto = new PaysByIdDto(pays);
        return Response.ok(paysByIdDto).build();
    }

    @GET
    @Path("{codeIso31661}/subdivisions")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Obtenir subdivisions", description = "Obtenir les subdivisions d'un pays via le code iso 3166_1 du pays")
    @APIResponse(responseCode = "200", description = "Ok, subdivions trouvées")
    @APIResponse(responseCode = "404", description = "Subdivisions non trouvées")
    public Response getSubdivisionsByPays(@PathParam("codeIso31661") String codeIso31661){
        List<SubdivisionEntity> subdivisionEntities = subdivisionRepository.findByPaysCodePays(codeIso31661);
        if(subdivisionEntities == null || subdivisionEntities.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("Aucune subdivisions trouvés pour ce pays").build();
        }
        List<SubdivisionDto> subdivisionByPaysDtoList = SubdivisionDto.toDtoList(subdivisionEntities);
        return Response.ok(subdivisionByPaysDtoList).build();
    }
}
