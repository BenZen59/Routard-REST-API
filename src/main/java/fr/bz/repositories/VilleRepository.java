package fr.bz.repositories;

import fr.bz.entities.VilleEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class VilleRepository implements PanacheRepositoryBase<VilleEntity, Integer> {

}
