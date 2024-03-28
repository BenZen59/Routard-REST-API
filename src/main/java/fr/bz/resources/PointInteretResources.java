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

import java.util.Collections;
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
        // Vérification si les ID spécifiés existent dans la base de données
        if (foundSubdivision == null && idSubdivision != 0) {
            return Response.status(Response.Status.NOT_FOUND)
                    .type(MediaType.TEXT_PLAIN)
                    .entity("La subdivision avec l'ID " + idSubdivision + " n'existe pas dans la base de données")
                    .build();
        }
        if (foundCategorie == null && idCategorie != 0) {
            return Response.status(Response.Status.NOT_FOUND)
                    .type(MediaType.TEXT_PLAIN)
                    .entity("La catégorie avec l'ID " + idCategorie + " n'existe pas dans la base de données")
                    .build();
        }
        if (foundSubdivision != null && foundCategorie != null) {
            pointsInterets = pointInteretRepository.findBySubdivisionAndCategorie(idSubdivision, idCategorie);
        } else if (foundSubdivision != null) {
            pointsInterets = pointInteretRepository.findBySubdivision(idSubdivision);
        } else if (foundCategorie != null) {
            pointsInterets = pointInteretRepository.findByCategorie(idCategorie);
        } else {
            return Response.ok(PointInteretDto.toDtoList(pointsInterets)).build();
        }
        if (pointsInterets.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("Aucun résultats trouvées").build();
        }
        List<PointInteretDto> pointInteretDtoList = PointInteretDto.toDtoList(pointsInterets);
        return Response.ok(pointInteretDtoList).build();
    }
}
