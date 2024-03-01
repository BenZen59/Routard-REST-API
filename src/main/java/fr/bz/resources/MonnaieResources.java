package fr.bz.resources;

import fr.bz.dto.ContinentDto;
import fr.bz.dto.MonnaieDto;
import fr.bz.entities.MonnaieEntity;
import fr.bz.repositories.MonnaieRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
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
    @Operation(summary = "Monnaie par code", description = "Chercher les monnaies par code")
    @APIResponse(responseCode = "200", description = "Ok, monnaie trouvé")
    @APIResponse(responseCode = "404", description = "Monnaie non trouvé")
    @Path("{codeIsoMonnaie}")
    public Response getById(@PathParam("codeIsoMonnaie") String codeIsoMonnaie) {
        MonnaieEntity monnaie = monnaieRepository.findById(codeIsoMonnaie);
        if (monnaie == null)
            return Response.status(404, "Ce code de monnaie n'existe pas !").build();
        else

            return Response.ok(monnaie).build();
    }
}

