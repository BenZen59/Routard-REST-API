package fr.bz.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "VILLE")
@Getter
public class VilleEntity {
    @Id
    @Column(name = "ID_VILLE")
    private int idVille;
    @Column(name = "NOM_VILLE")
    private String nomVille;
    @ManyToOne
    @JoinColumn(name = "ID_SUBDIVISION", referencedColumnName = "ID_SUBDIVISION")
    private SubdivisionEntity subdivision;
    @ManyToOne
    @JoinColumn(name = "CODE_CLIMAT", referencedColumnName = "CODE_CLIMAT")
    private TypeClimatEntity typeClimat;
}
