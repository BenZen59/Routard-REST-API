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
        return Response.ok(ContinentDto.toDtoList(continentEntities)).build();
    }

    @GET
    @Operation(summary = "Continent par code", description = "Chercher les continents par code")
    @APIResponse(responseCode = "200", description = "Ok, continent trouvé")
    @APIResponse(responseCode = "404", description = "Continent non trouvé")
    @Path("{codeContinent}")
    public Response getById(@PathParam("codeContinent") String codeContinent) {
        ContinentEntity continent = continentRepository.findById(codeContinent);
        if (continent == null)
            return Response.status(404, "Ce code de continent n'existe pas !").build();
        else

            return Response.ok(continent).build();
    }

    @GET
    @Path("/{codeContinent}/pays")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaysByContinent(@PathParam("codeContinent") String codeContinent) {
        List<PaysEntity> paysEntities = (List<PaysEntity>) paysRepository.findById(codeContinent);
        if (paysEntities.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(paysEntities).build();

    }}

