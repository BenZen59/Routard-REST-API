package fr.bz.resources;

import fr.bz.dto.LangueDto;
import fr.bz.dto.PaysDto;
import fr.bz.entities.LangueEntity;
import fr.bz.entities.PaysEntity;
import fr.bz.repositories.LangueRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/langue/")
@Tag(name="Langue")
public class LangueResources {
    @Inject
    private LangueRepository langueRepository;

    @GET
    public Response getAll() {
        List<LangueEntity> langueEntities = langueRepository.listAll();
        return Response.ok(LangueDto.toDtoList(langueEntities)).build();
    }
}
