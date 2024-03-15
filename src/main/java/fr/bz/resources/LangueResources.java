package fr.bz.resources;

import fr.bz.dto.LangueDto;
import fr.bz.dto.NewLangueDto;
import fr.bz.dto.NewPaysDto;
import fr.bz.dto.PaysDto;
import fr.bz.entities.ContinentEntity;
import fr.bz.entities.LangueEntity;
import fr.bz.entities.MonnaieEntity;
import fr.bz.entities.PaysEntity;
import fr.bz.repositories.LangueRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/langues/")
@Tag(name = "Langue")
public class LangueResources {
    @Inject
    private LangueRepository langueRepository;

    @GET
    public Response getAll() {
        List<LangueEntity> langueEntities = langueRepository.listAll();
        return Response.ok(LangueDto.toDtoList(langueEntities)).build();
    }

    @GET
    @Path("{isoLangue}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Langues par Id", description = "Chercher les langues par id")
    @APIResponse(responseCode = "200", description = "Ok, langue trouvée")
    @APIResponse(responseCode = "404", description = "Langue non trouvée")
    public Response getById(@PathParam("isoLangue") String isoLangue) {
        LangueEntity pays = langueRepository.findById(isoLangue);
        if (pays == null)
            return Response.status(404, "Ce code de langue n'existe pas !").build();
        else
            return Response.ok(pays).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Créer une langue", description = "Créer une nouvelle langue")
    @APIResponse(responseCode = "201", description = "Nouvelle langue crée avec succès")
    @APIResponse(responseCode = "400", description = "Mauvaise requête, les données envoyées ne sont pas valides")
    @Transactional
    public Response createLangue(NewLangueDto newLangueDto) {
        if (newLangueDto == null || newLangueDto.getIsoLangue() == null || newLangueDto.getNomLangue() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Les données envoyées ne sont pas valides").build();
        }

        if (newLangueDto.getIsoLangue().length() != 2) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Le code du pays doit faire 2 caractères").build();
        }

        LangueEntity langueEntity = LangueEntity
                .builder()
                .isoLangue(newLangueDto.getIsoLangue().toLowerCase())
                .nomLangue(newLangueDto.getNomLangue())
                .build();
        langueRepository.persist(langueEntity);
        return Response.status(201).entity("Nouvelle langue crée avec succès").build();
    }

    @DELETE
    @Path("{isoLangue}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Supprimer une langue", description = "Supprimer une langue existante")
    @APIResponse(responseCode = "200", description = "Langue supprimée avec succès")
    @APIResponse(responseCode = "404", description = "Langue non trouvée")
    @Transactional
    public Response deleteLangue(@PathParam("isoLangue") String isoLangue){
        LangueEntity langueEntity = langueRepository.findById(isoLangue.toLowerCase());
        if (langueEntity == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("La langue n'a pas été trouvée").build();
        }
        langueRepository.deleteById(isoLangue);
        return Response.ok("La langue a été supprimée avec succès").build();
    }
}
