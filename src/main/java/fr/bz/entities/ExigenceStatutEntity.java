package fr.bz.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity(name="EXIGENCE_STATUT")
public class ExigenceStatutEntity {
    @Id
    @Column(name="ID_STATUT")
    private Integer idStatut;
    @Column(name="LIBELLE")
    private String nomStatut;

    @OneToMany(mappedBy = "exigenceStatut", fetch = FetchType.LAZY)
    private Set<FormaliteExigenceEntity> formaliteExigenceEntities;
}
