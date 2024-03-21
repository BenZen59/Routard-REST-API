package fr.bz.repositories;

import fr.bz.entities.ContinentEntity;
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

    public List<PaysEntity> findByContinentAndName(ContinentEntity continent, String nomPays) {
        Query query = getEntityManager().createQuery("SELECT p FROM PAYS p WHERE p.continent = :continent AND p.nomPays = :nomPays");
        query.setParameter("continent", continent);
        query.setParameter("nomPays", nomPays);
        return query.getResultList();
    }

    public List<PaysEntity> findByContinent(ContinentEntity continent) {
        Query query = getEntityManager().createQuery("SELECT p FROM PAYS p WHERE p.continent = :continent");
        query.setParameter("continent", continent);
        return query.getResultList();
    }

    public List<PaysEntity> findByName(String nomPays) {
        Query query = getEntityManager().createQuery("SELECT p FROM PAYS p WHERE p.nomPays = :nomPays");
        query.setParameter("nomPays", nomPays);
        return query.getResultList();
    }
}
