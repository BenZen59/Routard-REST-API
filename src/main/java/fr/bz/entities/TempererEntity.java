package fr.bz.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "TEMPERER")
@Getter
public class TempererEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_MOIS", referencedColumnName = "ID_MOIS")
    private MoisEntity mois;
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_VILLE", referencedColumnName = "ID_VILLE")
    private VilleEntity ville;
    @Column(name = "TEMPERATURE_MOYENNE")
    private float temperatureMoyenne;
    @Column(name = "HUMIDITE_MOYENNE")
    private int humiditeMoyenne;
    @Column(name = "PRECIPITATION_MOYENNE")
    private float precipitationMoyenne;

}
