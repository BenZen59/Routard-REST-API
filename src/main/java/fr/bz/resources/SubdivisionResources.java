package fr.bz.resources;

import fr.bz.dto.PaysByContinentDto;
import fr.bz.dto.PaysByIdDto;
import fr.bz.dto.SubdivisionDto;
import fr.bz.dto.VilleDto;
import fr.bz.entities.ContinentEntity;
import fr.bz.entities.PaysEntity;
import fr.bz.entities.SubdivisionEntity;
import fr.bz.entities.VilleEntity;
import fr.bz.repositories.SubdivisionRepository;
import fr.bz.repositories.VilleRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/subdivisions/")
@Tag(name = "Subdivision")
@Produces(MediaType.APPLICATION_JSON)
public class SubdivisionResources {
    @Inject
    private SubdivisionRepository subdivisionRepository;

    @Inject
    private VilleRepository villeRepository;

    @GET
    @Path("{idSubdivision}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Subdivision par Id", description = "Chercher les subdivisions par id")
    @APIResponse(responseCode = "200", description = "Ok, subdivision trouvé")
    @APIResponse(responseCode = "404", description = "Subdivision non trouvé")
    public Response getById(@PathParam("idSubdivision") int idSubdivision) {
        SubdivisionEntity subdivision = subdivisionRepository.findById(idSubdivision);
        if (subdivision == null) {
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("Cet id de subdivision n'existe pas").build();
        }
        SubdivisionDto subdivisionDto = new SubdivisionDto(subdivision);
        return Response.ok(subdivisionDto).build();
    }

    @GET
    @Operation(summary = "Villes d'une subdivision", description = "Récupérer villes d'une subdivision par son id")
    @APIResponse(responseCode = "200", description = "Ok, villes trouvées")
    @APIResponse(responseCode = "404", description = "Aucune villes trouvées pour cette subdivision")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{idSubdivision}/villes")
    public Response getVillesBySubdivision(@PathParam("idSubdivision") int idSubdivision) {
        SubdivisionEntity foundSubdivision = subdivisionRepository.findById(idSubdivision);
        if (foundSubdivision == null)
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("Cet id de subdivision n'existe pas").build();

        List<VilleEntity> villeEntities = villeRepository.findVillesIdSubdivision(idSubdivision);
        List<VilleDto> villeDtoList = VilleDto.toDtoList(villeEntities);
        return Response.ok(villeDtoList).build();
    }
}
