package fr.bz.resources;

import fr.bz.dto.ContinentDto;
import fr.bz.dto.PointInteretDto;
import fr.bz.entities.CategorieEntity;
import fr.bz.entities.PointInteretEntity;
import fr.bz.entities.SubdivisionEntity;
import fr.bz.repositories.CategorieRepository;
import fr.bz.repositories.PointInteretRepository;
import fr.bz.repositories.SubdivisionRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/pointsinterets/")
@Tag(name = "Point d'intérêt")
public class PointInteretResources {
    @Inject
    private PointInteretRepository pointInteretRepository;
    @Inject
    private SubdivisionRepository subdivisionRepository;
    @Inject
    private CategorieRepository categorieRepository;

    @GET
    @Path("search")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Obtenir points d'intérêts", description = "Obtenir les points d'intérêts par catégorie et/ou par subdivision")
    @APIResponse(responseCode = "200", description = "Ok, points d'intérêt non  trouvés")
    @APIResponse(responseCode = "404", description = "Points d'intérêts non trouvés")
    public Response getById(@QueryParam("idSubdivision") int idSubdivision, @QueryParam("idCategorie") int idCategorie) {
        List<PointInteretEntity> pointsInterets = pointInteretRepository.listAll();
        SubdivisionEntity foundSubdivision = subdivisionRepository.findById(idSubdivision);
        CategorieEntity foundCategorie = categorieRepository.findById(idCategorie);
        if (foundSubdivision != null && foundCategorie != null) {
            pointsInterets = pointInteretRepository.findBySubdivisionAndCategorie(foundSubdivision, foundCategorie);
        } else if (foundSubdivision != null) {
            pointsInterets = pointInteretRepository.findBySubdivision(foundSubdivision);
        } else if (foundCategorie != null) {
            pointsInterets = pointInteretRepository.findByCategorie(idCategorie);
        } else {
            return Response.ok(PointInteretDto.toDtoList(pointsInterets)).build();
        }

        List<PointInteretDto> pointInteretDtoList = PointInteretDto.toDtoList(pointsInterets);
        return Response.ok(pointInteretDtoList).build();

    }
}
