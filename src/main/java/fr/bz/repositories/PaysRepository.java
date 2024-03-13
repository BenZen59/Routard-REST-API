package fr.bz.repositories;

import fr.bz.entities.PaysEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.Query;

import java.util.List;

@RequestScoped
public class PaysRepository implements PanacheRepositoryBase<PaysEntity, String> {
    public List<PaysEntity> findByContinentCodeContinent(String codeContinent) {
        Query query = getEntityManager().createQuery("SELECT p.nomPays FROM PAYS p WHERE p.continent.codeContinent = :codeContinent");
        query.setParameter("codeContinent", codeContinent);
        return query.getResultList();
    }
}
