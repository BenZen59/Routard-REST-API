package fr.bz.repositories;

import fr.bz.entities.LangueEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class LangueRepository implements PanacheRepositoryBase<LangueEntity,String> {

}
