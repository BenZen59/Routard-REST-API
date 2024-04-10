package fr.bz.repositories;

import fr.bz.entities.VisaExemptionEntity;
import fr.bz.entities.VisaExemptionPK;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;

@RequestScoped
public class VisaExemptionRepository implements PanacheRepositoryBase<VisaExemptionEntity, VisaExemptionPK> {
    public List<VisaExemptionEntity> listVisaExemptedPays(String codePays) {
        return list("visaExemptionPK.codePays = ?1", codePays);
    }
}
