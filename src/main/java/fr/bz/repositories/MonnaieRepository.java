package fr.bz.repositories;

import fr.bz.entities.MonnaieEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.runtime.annotations.IgnoreProperty;
import jakarta.enterprise.context.RequestScoped;
import lombok.Generated;

@RequestScoped
@Generated
public class MonnaieRepository implements PanacheRepositoryBase<MonnaieEntity, String> {

}
