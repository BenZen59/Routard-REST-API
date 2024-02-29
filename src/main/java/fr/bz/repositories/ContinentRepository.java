package fr.bz.repositories;

import fr.bz.entities.ContinentEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class ContinentRepository implements PanacheRepositoryBase<ContinentEntity, String> {


}
