package fr.bz.repositories;

import fr.bz.entities.CategorieEntity;
import fr.bz.entities.PointInteretEntity;
import fr.bz.entities.SubdivisionEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.Query;

import java.util.List;

@RequestScoped
public class PointInteretRepository implements PanacheRepositoryBase<PointInteretEntity, Integer> {
    public List<PointInteretEntity> findBySubdivisionAndCategorie(SubdivisionEntity foundSubdivision, CategorieEntity foundCategorie) {
        return find("subdivision = ?1 and categories = ?2", foundSubdivision, foundCategorie).list();
    }

    public List<PointInteretEntity> findBySubdivision(SubdivisionEntity foundSubdivision) {
        return find("subdivision = ?1", foundSubdivision).list();
    }

    public List<PointInteretEntity> findByCategorie(int idCategorie) {
        Query query = getEntityManager().createQuery("SELECT pi FROM POINT_INTERET pi JOIN pi.categoriserEntityList c WHERE c.categorie.idCategorie = :idCategorie");
        query.setParameter("idCategorie", idCategorie);
        return query.getResultList();
    }

}
