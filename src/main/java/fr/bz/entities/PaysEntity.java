package fr.bz.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "PAYS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
