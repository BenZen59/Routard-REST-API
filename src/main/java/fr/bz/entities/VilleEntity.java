package fr.bz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "VILLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
