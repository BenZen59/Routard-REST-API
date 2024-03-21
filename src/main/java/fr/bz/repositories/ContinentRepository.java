package fr.bz.repositories;

import fr.bz.entities.ContinentEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;

@RequestScoped
public class ContinentRepository implements PanacheRepositoryBase<ContinentEntity, String> {


    public ContinentEntity findByCodeContinent(String codeContinent) {
        List<ContinentEntity> continents = list("codeContinent = ?1", codeContinent);
        if (continents.isEmpty()) {
            return null;
        } else {
            return continents.get(0);
        }
    }

    public ContinentEntity findByName(String nomContinent) {
        List<ContinentEntity> continents = list("nomContinent", nomContinent);
        if (continents.isEmpty()) {
            return null;
        } else {
            return continents.get(0);
        }
    }
}
