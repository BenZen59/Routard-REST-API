package fr.bz.resources;

import fr.bz.dto.FormaliteExigenceDto;
import fr.bz.dto.VisaExemptionDto;
import fr.bz.entities.FormaliteExigenceEntity;
import fr.bz.entities.VisaExemptionEntity;
import fr.bz.repositories.PaysFormaliteExigenceRepository;
import fr.bz.repositories.VisaExemptionRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/formalites_entree/")
@Tag(name = "Formalités d'entrée")
@Produces(MediaType.APPLICATION_JSON)
public class FormaliteEntreeResources {
    @Inject
    private PaysFormaliteExigenceRepository paysFormaliteExigenceRepository;

    @Inject
    private VisaExemptionRepository visaExemptionRepository;

    @GET
    @Path("/{codeIso31661}/formalites_admins")
    public Response getFormalitesAdmin(@PathParam("codeIso31661") String codePays) {
        List<FormaliteExigenceEntity> results = paysFormaliteExigenceRepository.listFormalitesAmin(codePays);

        return Response.ok(FormaliteExigenceDto.getDtoList(results)).build();
    }

    @GET
    @Path("/{codeIso31661}/formalites_medicales")
    public Response getFormalitesMedicale(@PathParam("codeIso31661") String codePays) {
        List<FormaliteExigenceEntity> results = paysFormaliteExigenceRepository.listFormalitesMedicales(codePays);

        return Response.ok(FormaliteExigenceDto.getDtoList(results)).build();
    }

    @GET
    @Path("/{codeIso31661}/visa_exempte")
    public Response getVisaExemptedPays(@PathParam("codeIso31661") String codePays) {
        List<VisaExemptionEntity> results = visaExemptionRepository.listVisaExemptedPays(codePays);

        return Response.ok(VisaExemptionDto.getDtos(results)).build();
    }
}
