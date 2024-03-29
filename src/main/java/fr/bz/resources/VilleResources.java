package fr.bz.resources;

import fr.bz.dto.VilleDto;
import fr.bz.dto.TempererDto;
import fr.bz.entities.MoisEntity;
import fr.bz.entities.TempererEntity;
import fr.bz.entities.VilleEntity;
import fr.bz.repositories.MoisRepository;
import fr.bz.repositories.TempererRepository;
import fr.bz.repositories.VilleRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/villes/")
@Tag(name = "Ville")
public class VilleResources {
    @Inject
    private VilleRepository villeRepository;

    @Inject
    private MoisRepository moisRepository;

    @Inject
    private TempererRepository tempererRepository;

    @GET
    @Path("{idVille}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Villes par Id", description = "Chercher les villes par id")
    @APIResponse(responseCode = "200", description = "Ok, ville trouvé")
    @APIResponse(responseCode = "404", description = "Ville non trouvé")
    public Response getById(@PathParam("idVille") int idVille) {
        VilleEntity ville = villeRepository.findById(idVille);
        if (ville == null) {
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("Cet id de ville n'existe pas !").build();
        }
        VilleDto villeDto = new VilleDto(ville);
        return Response.ok(villeDto).build();
    }

    @GET
    @Path("{idVille}/meteo")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Metéo par ville", description = "Voir la météo d'une ville")
    @APIResponse(responseCode = "200", description = "Ok, ville trouvé")
    @APIResponse(responseCode = "404", description = "Ville non trouvé")
    public Response getTempererbyMois(@PathParam("idVille") int idVille, @QueryParam("idMois") int idMois) {
        VilleEntity foundVille = villeRepository.findById(idVille);
        MoisEntity foundMois = moisRepository.findById(idMois);
        List<TempererEntity> temperature = tempererRepository.findTemperaturebyVille(idVille);
        if (foundVille == null) {
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("Cet id de ville n'existe pas !").build();
        }
        if (foundMois == null && idMois != 0) {
            return Response.status(Response.Status.NOT_FOUND)
                    .type(MediaType.TEXT_PLAIN)
                    .entity("L'id du mois n'existe pas")
                    .build();
        }
        if (foundMois != null) {
            temperature = tempererRepository.findTemperaturebyMoisAndVille(idVille, idMois);
        }
        List<TempererDto> tempererDtoList = TempererDto.toDtoList(temperature);
        return Response.ok(tempererDtoList).build();
    }
}
