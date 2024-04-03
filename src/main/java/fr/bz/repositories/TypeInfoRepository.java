package fr.bz.repositories;

import fr.bz.entities.TypeInfoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class TypeInfoRepository implements PanacheRepositoryBase<TypeInfoEntity, Integer> {
}
