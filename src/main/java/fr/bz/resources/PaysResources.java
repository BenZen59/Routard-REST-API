package fr.bz.resources;

import fr.bz.dto.PaysDto;
import fr.bz.entities.ContinentEntity;
import fr.bz.entities.MonnaieEntity;
import fr.bz.entities.PaysEntity;
import fr.bz.repositories.ContinentRepository;
import fr.bz.repositories.PaysRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/pays/")
@Tag(name = "Pays")

public class PaysResources {
    @Inject
    private PaysRepository paysRepository;
    @Inject
    private ContinentRepository continentRepository;
    @GET
    public Response getAll() {
        List<PaysEntity> paysEntities = paysRepository.listAll();
        return Response.ok(PaysDto.toDtoList(paysEntities)).build();
    }

    @GET
    @Path("{codeIso31661}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Pays par Id", description = "Chercher les pays par id")
    @APIResponse(responseCode = "200", description = "Ok, pays trouvé")
    @APIResponse(responseCode = "404", description = "Pays non trouvé")

    public Response getById(@PathParam("codeIso31661") String codeIso31661) {
        PaysEntity pays = paysRepository.findById(codeIso31661);
        if (pays == null)
            return Response.status(404, "Ce code de pays n'existe pas !").build();
        else
            return Response.ok(pays).build();
    }

    @POST
    @Path("/createPays")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Créer un pays", description = "Créer un nouveau pays")
    @APIResponse(responseCode = "201", description = "Nouveau Pays crée avec succès")
    @APIResponse(responseCode = "400", description = "Mauvaise requête, les données envoyées ne sont pas valides")
    @Transactional
    public Response createPays(@Valid PaysEntity nouveauPaysPost){
        PaysEntity nouveauPays = PaysEntity.fromPostData(nouveauPaysPost.getCodeIso31661(),nouveauPaysPost.getNomPays(), nouveauPaysPost.getContinent().getCodeContinent(), nouveauPaysPost.getMonnaie().getCodeIsoMonnaie());
            if (nouveauPays == null || nouveauPays.getCodeIso31661() == null ||nouveauPays.getNomPays() == null || nouveauPays.getContinent() == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Les données envoyées ne sont pas valides").build();
            }

            if (nouveauPays.getCodeIso31661().length() > 2) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Le code du pays ne doit pas faire plus de 2 caractères").build();
            }

        if (nouveauPays.getMonnaie() == null) {
            nouveauPays.setMonnaie(null);
        }

        ContinentEntity continent = continentRepository.findByCodeContinent(nouveauPays.getContinent().getCodeContinent());
        if (continent == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Le code du continent n'est pas valide").build();
        }
        nouveauPays.setContinent(continent);
        paysRepository.persist(nouveauPays);
            return Response.status(201).entity("Nouveau pays crée avec succès").build();
    }
}
