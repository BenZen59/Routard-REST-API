package fr.bz.repositories;

import fr.bz.entities.VilleEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.Query;

import java.util.List;

@RequestScoped
public class VilleRepository implements PanacheRepositoryBase<VilleEntity, Integer> {

    public List<VilleEntity> findVillesIdSubdivision(int idSubdivision) {
        Query query = getEntityManager().createQuery("SELECT v FROM VILLE v WHERE v.subdivision.idSubdivision = :idSubdivision");
        query.setParameter("idSubdivision", idSubdivision);
        return query.getResultList();
    }
}
