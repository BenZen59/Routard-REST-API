package fr.bz.repositories;

import fr.bz.entities.InformerEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.Query;

import java.util.List;

@RequestScoped
public class InformerRepository implements PanacheRepositoryBase<InformerEntity, Integer> {
    public List<InformerEntity> findInformationByPaysAndTypeInfo(String codeIso31661, int idTypeInfo) {
        Query query = getEntityManager().createQuery("SELECT i FROM INFORMER i WHERE  i.pays.codeIso31661 = :codeIso31661 AND i.typeInfo.idTypeInfo = :idTypeInfo");
        query.setParameter("codeIso31661", codeIso31661);
        query.setParameter("idTypeInfo", idTypeInfo);
        return query.getResultList();
    }

    public List<InformerEntity> findInformationByPays(String codeIso31661) {
        Query query = getEntityManager().createQuery("SELECT i FROM INFORMER i WHERE  i.pays.codeIso31661 = :codeIso31661");
        query.setParameter("codeIso31661", codeIso31661);
        return query.getResultList();
    }
}
