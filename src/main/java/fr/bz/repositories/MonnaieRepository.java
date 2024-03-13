package fr.bz.repositories;

import fr.bz.entities.MonnaieEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class MonnaieRepository implements PanacheRepositoryBase<MonnaieEntity, String> {

}
