package fr.bz.resources;

import fr.bz.dto.NewPaysDto;
import fr.bz.dto.PaysDto;
import fr.bz.entities.ContinentEntity;
import fr.bz.entities.PaysEntity;
import fr.bz.repositories.ContinentRepository;
import fr.bz.repositories.PaysRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
    ContinentRepository continentRepository;

    @GET
    public Response getAll() {
        List<PaysEntity> paysEntities = paysRepository.listAll();
        return Response.ok(PaysDto.toDtoList(paysEntities)).build();
    }

    @GET
    @Path("{codeIso31661}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Pays par Id", description = "Chercher les pays par id")
    @APIResponse(responseCode = "200", description = "Ok, pays trouvé")
    @APIResponse(responseCode = "404", description = "Pays non trouvé")

    public Response getById(@PathParam("codeIso31661") String codeIso31661) {
        PaysEntity pays = paysRepository.findById(codeIso31661);
        if (pays == null)
            return Response.status(404, "Ce code de pays n'existe pas !").build();
        else
            return Response.ok(pays).build();
    }

    @POST
    @Path("createPays")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Créer un pays", description = "Créer un nouveau pays")
    @APIResponse(responseCode = "201", description = "Nouveau Pays crée avec succès")
    @APIResponse(responseCode = "400", description = "Mauvaise requête, les données envoyées ne sont pas valides")
    @Transactional
    public Response createPays(NewPaysDto newPaysDto) {
        if (newPaysDto == null || newPaysDto.getCodeIso31661() == null || newPaysDto.getNomPays() == null || newPaysDto.getCodeContinent() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Les données envoyées ne sont pas valides").build();
        }

        if (newPaysDto.getCodeIso31661().length() > 2) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Le code du pays ne doit pas faire plus de 2 caractères").build();
        }

        ContinentEntity foundContinent = continentRepository.findByCodeContinent(newPaysDto.getCodeContinent());
        if(foundContinent == null)
            return Response.ok("Continent n'existe pas.").status(Response.Status.NOT_FOUND).build();

        PaysEntity paysEntity = PaysEntity
                .builder()
                .codeIso31661(newPaysDto.getCodeIso31661())
                .nomPays(newPaysDto.getNomPays())
                 .continent(foundContinent)
                 .build();

        paysRepository.persist(paysEntity);

        return Response.status(201).entity("Nouveau pays crée avec succès").build();
    }
}
