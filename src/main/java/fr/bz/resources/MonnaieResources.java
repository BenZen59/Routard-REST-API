package fr.bz.resources;

import fr.bz.dto.MonnaieDto;
import fr.bz.dto.NewMonnaieDto;
import fr.bz.entities.MonnaieEntity;
import fr.bz.repositories.MonnaieRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/monnaies/")
@Tag(name = "Monnaie")
@Produces(MediaType.APPLICATION_JSON)
public class MonnaieResources {
    @Inject
    private MonnaieRepository monnaieRepository;

    @GET
    public Response getAll() {
        List<MonnaieEntity> monnaieEntities = monnaieRepository.listAll();
        return Response.ok(MonnaieDto.toDtoList(monnaieEntities)).build();
    }


    @GET
    @Path("{codeIsoMonnaie}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Monnaie par code", description = "Chercher les monnaies par code")
    @APIResponse(responseCode = "200", description = "Ok, monnaie trouvé")
    @APIResponse(responseCode = "404", description = "Monnaie non trouvé")
    public Response getById(@PathParam("codeIsoMonnaie") String codeIsoMonnaie) {
        MonnaieEntity monnaie = monnaieRepository.findById(codeIsoMonnaie);
        if (monnaie == null)
            return Response.status(404, "Ce code de monnaie n'existe pas !").build();
        else

            return Response.ok(monnaie).build();
    }


    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Créer une monnaie", description = "Créer une nouvelle monnaie")
    @APIResponse(responseCode = "201", description = "Nouvelle monnaie crée avec succès")
    @APIResponse(responseCode = "400", description = "Mauvaise requête, les données envoyées ne sont pas valides")
    @Transactional

    public Response createMonnaie(NewMonnaieDto newMonnaieDto) {
        if (newMonnaieDto == null || newMonnaieDto.getCodeIsoMonnaie() == null || newMonnaieDto.getNomDevise() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Les données envoyées ne sont pas valides").build();
        }

        if (newMonnaieDto.getCodeIsoMonnaie().length() != 3) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Le code de la monnaie doit faire 3 caractères").build();
        }

        MonnaieEntity monnaieEntity = MonnaieEntity
                .builder()
                .codeIsoMonnaie(newMonnaieDto.getCodeIsoMonnaie().toUpperCase())
                .nomDevise(newMonnaieDto.getNomDevise())
                .build();
        monnaieRepository.persist(monnaieEntity);
        return Response.status(201).entity("Nouvelle monnaie créée avec succès").build();
    }

    @DELETE
    @Path("{codeIsoMonnaie}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Supprimer une monnaie", description = "Supprimer une monnaie existante")
    @APIResponse(responseCode = "200", description = "Monnaie supprimée avec succès")
    @APIResponse(responseCode = "404", description = "Monnaie non trouvée")
    @Transactional
    public Response deleteMonnaie(@PathParam("codeIsoMonnaie") String codeIsoMonnaie){
        MonnaieEntity monnaieEntity = monnaieRepository.findById(codeIsoMonnaie.toUpperCase());
        if (monnaieEntity == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("La monnaie n'a pas été trouvée").build();
        }
        monnaieRepository.deleteById(codeIsoMonnaie);
        return Response.ok("La monnaie a été supprimée avec succès").build();
    }
}

