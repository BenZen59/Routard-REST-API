package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "TYPE_FORMALITE")
@Getter
@Setter
public class TypeFormaliteEntity {
    @Id
    @Column(name = "ID_TYPE")
    private int idTypeFormalite;
    @Column(name = "NOM_TYPE")
    private String nomTypeFormalite;

    @OneToMany(mappedBy = "typeFormalite")
    private Set<FormaliteEntreeEntity> formalitesEntree;
}
