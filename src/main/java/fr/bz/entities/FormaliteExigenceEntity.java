package fr.bz.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity(name="PAYS_FORMALITE_EXIGENCE")
public class FormaliteExigenceEntity {
    @EmbeddedId
    private PaysFormalitePK paysFormalitePK;

    @ManyToOne
    @MapsId("codePays")
    @JoinColumn(name="CODE_PAYS", columnDefinition = "CHAR(2)")
    private PaysEntity pays;

    @ManyToOne
    @MapsId("idFormalite")
    @JoinColumn(name="ID_FORMALITE")
    private FormaliteEntreeEntity formaliteEntree;

    @Column(name="NOTES")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "ID_STATUT")
    private ExigenceStatutEntity exigenceStatut;
}
