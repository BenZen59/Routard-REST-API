package fr.bz.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Entity(name = "VISA_EXEMPTION")
public class VisaExemptionEntity {
    @EmbeddedId
    private VisaExemptionPK visaExemptionPK;

    @ManyToOne
    @MapsId("codePays")
    @JoinColumn(name="CODE_PAYS", columnDefinition = "CHAR(2)")
    private PaysEntity pays;

    @ManyToOne
    @MapsId("codePaysExempted")
    @JoinColumn(name="CODE_PAYS_EXEMPTE", columnDefinition = "CHAR(2)")
    private PaysEntity paysExempte;

    @Column(name = "DUREE_MIN")
    private int dureeMin;

    @Column(name = "DUREE_MAX")
    private int dureeMax;

    @Column(name="DATE_APPLIQUEE_DEBUT")
    private LocalDate dateDebut;

    @Column(name="DATE_APPLIQUEE_FIN")
    private LocalDate dateFin;
}
