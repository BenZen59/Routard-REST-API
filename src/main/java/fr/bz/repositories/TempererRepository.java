package fr.bz.repositories;

import fr.bz.entities.TempererEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.Query;

import java.util.List;

@RequestScoped
public class TempererRepository implements PanacheRepositoryBase<TempererEntity, Integer> {
    public List<TempererEntity> findTemperaturebyMoisAndVille(int idVille, int idMois) {
        Query query = getEntityManager().createQuery("SELECT t FROM TEMPERER t WHERE  t.ville.idVille= :idVille AND t.mois.idMois = :idMois");
        query.setParameter("idVille", idVille);
        query.setParameter("idMois", idMois);
        return query.getResultList();
    }

    public List<TempererEntity> findTemperaturebyVille(int idVille) {
        Query query = getEntityManager().createQuery("SELECT t FROM TEMPERER t WHERE  t.ville.idVille= :idVille");
        query.setParameter("idVille", idVille);
        return query.getResultList();
    }
}

