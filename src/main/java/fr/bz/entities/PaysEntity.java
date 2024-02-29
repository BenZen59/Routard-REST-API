package fr.bz.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "PAYS")
@Getter
@Setter
public class PaysEntity {
    @Id
    @Column(name = "CODE_ISO_3166_1")
    private String codeIso31661;
    @Column(name = "NOM_PAYS")
    private String nomPays;
    @ManyToOne
    @JoinColumn(name = "CODE_CONTINENT")
    private ContinentEntity continent;
}
