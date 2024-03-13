package fr.bz.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "PAYS")
@Getter
@Setter
@AllArgsConstructor
public class PaysEntity {
    @Id
    @Column(name = "CODE_ISO_3166_1")
    private String codeIso31661;
    @Column(name = "NOM_PAYS")
    private String nomPays;
    @ManyToOne
    @JoinColumn(name = "CODE_CONTINENT", referencedColumnName = "CODE_CONTINENT")
    private ContinentEntity continent;
    @ManyToOne
    @JoinColumn(name = "CODE_ISO_MONNAIE")
    private MonnaieEntity monnaie;

    public PaysEntity(String codeIso31661, String nomPays, String codeContinent, String codeMonnaie) {
        this.codeIso31661 = codeIso31661;
        this.nomPays = nomPays;
        this.continent = new ContinentEntity(codeContinent, null);
        this.monnaie = new MonnaieEntity(codeMonnaie, null);
    }

    public static PaysEntity fromPostData(String codeIso31661, String nomPays, String codeContinent, String codeMonnaie) {
        return new PaysEntity(codeIso31661, nomPays, codeContinent, codeMonnaie);
    }

    public PaysEntity() {

    }
}
