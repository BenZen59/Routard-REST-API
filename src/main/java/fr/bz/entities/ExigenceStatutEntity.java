package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="EXIGENCE_STATUT")
public class ExigenceStatutEntity {
    @Id
    @Column(name="ID_STATUT")
    private Integer idStatut;
    @Column(name="LIBELLE")
    private String nomStatut;
}
