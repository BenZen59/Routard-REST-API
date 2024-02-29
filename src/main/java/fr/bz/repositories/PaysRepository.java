package fr.bz.repositories;

import fr.bz.entities.PaysEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class PaysRepository implements PanacheRepositoryBase<PaysEntity, String> {
}
