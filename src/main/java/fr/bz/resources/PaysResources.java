package fr.bz.resources;

import fr.bz.dto.PaysDto;
import fr.bz.entities.PaysEntity;
import fr.bz.repositories.PaysRepository;
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

@Path("/pays/")
@Tag(name = "Pays")
@Produces(MediaType.APPLICATION_JSON)

public class PaysResources {
    @Inject
    private PaysRepository paysRepository;

    @GET
    public Response getAll() {
        List<PaysEntity> paysEntities = paysRepository.listAll();
        return Response.ok(PaysDto.toDtoList(paysEntities)).build();
    }

    @GET
    @Operation(summary = "Pays par Id", description = "Chercher les pays par id")
    @APIResponse(responseCode = "200", description = "Ok, pays trouvé")
    @APIResponse(responseCode = "404", description = "Pays non trouvé")
    @Path("{codeIso31661}")
    public Response getById(@PathParam("codeIso31661") String codeIso31661) {
        PaysEntity pays = paysRepository.findById(codeIso31661);
        if (pays == null)
            return Response.status(404, "Ce code de pays n'existe pas !").build();
        else
            return Response.ok(pays).build();
    }
}
