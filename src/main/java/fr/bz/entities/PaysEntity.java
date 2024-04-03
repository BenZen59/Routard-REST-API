package fr.bz.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "PAYS")
@Getter
public class PaysEntity {
    @Id
    @Column(name = "CODE_ISO_3166_1", columnDefinition = "CHAR(2)")
    private String codeIso31661;
    @Column(name = "NOM_PAYS")
    private String nomPays;
    @ManyToOne
    @JoinColumn(name = "CODE_CONTINENT", referencedColumnName = "CODE_CONTINENT")
    private ContinentEntity continent;
    @ManyToOne
    @JoinColumn(name = "CODE_ISO_MONNAIE")
    private MonnaieEntity monnaie;
    @OneToMany(mappedBy = "pays")
    private List<ParlerEntity> parlerEntityList;
}
