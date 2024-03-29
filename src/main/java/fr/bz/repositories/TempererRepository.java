package fr.bz.repositories;

import fr.bz.entities.TempererEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class TempererRepository implements PanacheRepositoryBase<TempererEntity, Integer> {
}
