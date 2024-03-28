package fr.bz.repositories;

import fr.bz.entities.PointInteretEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.Query;

import java.util.List;

@RequestScoped
public class PointInteretRepository implements PanacheRepositoryBase<PointInteretEntity, Integer> {
    public List<PointInteretEntity> findBySubdivisionAndCategorie(int idSubdivision, int idCategorie) {
        Query query = getEntityManager().createQuery("SELECT pi FROM POINT_INTERET pi " +
                "JOIN pi.avoirEntityList a " +
                "JOIN pi.categoriserEntityList c " +
                "WHERE a.subdivision.idSubdivision = :idSubdivision " +
                "AND c.categorie.idCategorie = :idCategorie");
        query.setParameter("idSubdivision", idSubdivision);
        query.setParameter("idCategorie", idCategorie);
        return query.getResultList();
    }

    public List<PointInteretEntity> findBySubdivision(int idSubdivision) {
        Query query = getEntityManager().createQuery("SELECT pi FROM POINT_INTERET pi JOIN pi.avoirEntityList a WHERE a.subdivision.idSubdivision = :idSubdivision");
        query.setParameter("idSubdivision", idSubdivision);
        return query.getResultList();
    }

    public List<PointInteretEntity> findByCategorie(int idCategorie) {
        Query query = getEntityManager().createQuery("SELECT pi FROM POINT_INTERET pi JOIN pi.categoriserEntityList c WHERE c.categorie.idCategorie = :idCategorie");
        query.setParameter("idCategorie", idCategorie);
        return query.getResultList();
    }

}
