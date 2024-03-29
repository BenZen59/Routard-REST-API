package fr.bz.repositories;

import fr.bz.entities.MoisEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.Query;

import java.util.List;

@RequestScoped
public class MoisRepository implements PanacheRepositoryBase<MoisEntity, Integer> {

}
