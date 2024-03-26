package fr.bz.repositories;

import fr.bz.entities.CategorieEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class CategorieRepository implements PanacheRepositoryBase<CategorieEntity, Integer> {
}
