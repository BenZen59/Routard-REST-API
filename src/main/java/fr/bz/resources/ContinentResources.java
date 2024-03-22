package fr.bz.resources;

import fr.bz.dto.ContinentDto;
import fr.bz.dto.PaysByContinentDto;
import fr.bz.entities.ContinentEntity;
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
    @Operation(summary = "Pays d'un continent", description = "Récupérer les pays d'un continent par son code")
    @APIResponse(responseCode = "200", description = "Ok, pays trouvés")
    @APIResponse(responseCode = "404", description = "Aucun pays trouvé pour ce continent")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{codeContinent}/pays")
    public Response getPaysByContinent(@PathParam("codeContinent") String codeContinent) {
        List<PaysEntity> paysEntities = paysRepository.findByContinentCodeContinent(codeContinent);
        // Vérifier si des pays ont été trouvés
        if (paysEntities == null || paysEntities.isEmpty()) {
         }
        // Mapper les entités de pays vers des DTO
        List<PaysByContinentDto> paysByContinentDtoList = PaysByContinentDto.toDtoList(paysEntities);
        return Response.ok(paysByContinentDtoList).build();
    }
}

