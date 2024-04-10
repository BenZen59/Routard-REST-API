package fr.bz.repositories;

import fr.bz.entities.FormaliteExigenceEntity;
import fr.bz.entities.PaysFormalitePK;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;

@RequestScoped
public class PaysFormaliteExigenceRepository implements PanacheRepositoryBase<FormaliteExigenceEntity, PaysFormalitePK> {
    public List<FormaliteExigenceEntity> listFormalitesAmin(String codePays) {
        return list("paysFormalitePK.codePays = ?1 and formaliteEntree.typeFormalite.nomTypeFormalite != 'Vaccines/Treatments'", codePays);
    }

    public List<FormaliteExigenceEntity> listFormalitesMedicales(String codePays) {
        return list("paysFormalitePK.codePays = ?1 and formaliteEntree.typeFormalite.nomTypeFormalite = 'Vaccines/Treatments'", codePays);
    }
}
