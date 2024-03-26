package fr.bz.resources;

import fr.bz.dto.CategorieDto;
import fr.bz.entities.CategorieEntity;
import fr.bz.repositories.CategorieRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/categories/")
@Tag(name = "Categorie")
public class CategorieResources {
    @Inject
    private CategorieRepository categorieRepository;

    @GET
    public Response getAll() {
        List<CategorieEntity> categorieEntities = categorieRepository.listAll();
        return Response.ok(CategorieDto.toDtoList(categorieEntities)).build();
    }
}
