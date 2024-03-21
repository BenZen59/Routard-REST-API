package fr.bz.resources;

import fr.bz.dto.ContinentDto;
import fr.bz.entities.ContinentEntity;
import fr.bz.entities.PaysEntity;
import fr.bz.repositories.ContinentRepository;
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

@Path("/continents/")
@Tag(name = "Continent")
@Produces(MediaType.APPLICATION_JSON)
public class ContinentResources {
    @Inject
    private ContinentRepository continentRepository;
    @Inject
    private PaysRepository paysRepository;

    @GET
    public Response getAll() {
        List<ContinentEntity> continentEntities = continentRepository.listAll();
        return Response.ok(ContinentDto. toDtoList(continentEntities)).build();
    }
    
    @GET
    @Operation(summary = "Pays d'un continent", description = "Récupérer les pays d'un continent par son code")
    @APIResponse(responseCode = "200", description = "Ok, pays trouvés")
    @APIResponse(responseCode = "404", description = "Aucun pays trouvé pour ce continent")
    @Path("{codeContinent}/pays")
    public Response getPaysByContinent(@PathParam("codeContinent") String codeContinent) {
        List<PaysEntity> paysEntities = paysRepository.findByContinentCodeContinent(codeContinent);
        if (paysEntities.isEmpty()) {
            return Response.status(404, "Aucun pays trouvé pour ce continent ! ").build();
        } else {
            return Response.ok(paysEntities).build();
        }
    }
}

