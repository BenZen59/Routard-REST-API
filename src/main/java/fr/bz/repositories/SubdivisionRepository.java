package fr.bz.repositories;

import fr.bz.entities.SubdivisionEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.Query;

import java.util.List;

@RequestScoped
public class SubdivisionRepository implements PanacheRepositoryBase<SubdivisionEntity, Integer> {

    public List<SubdivisionEntity> findByPaysCodePays(String codeIso31661) {
        Query query = getEntityManager().createQuery("SELECT s FROM SUBDIVISION s WHERE s.pays.codeIso31661 = :codeIso31661");
        query.setParameter("codeIso31661", codeIso31661);
        return query.getResultList();
    }
}
