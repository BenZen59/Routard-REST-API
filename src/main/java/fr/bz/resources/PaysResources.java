package fr.bz.resources;

import fr.bz.entities.PaysEntity;
import fr.bz.repositories.ContinentRepository;
import fr.bz.repositories.PaysRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/pays/")
@Tag(name = "Pays")

public class PaysResources {
    @Inject
    private PaysRepository paysRepository;

    @Inject
    ContinentRepository continentRepository;

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
        return Response.ok(pays).build();
    }
}
