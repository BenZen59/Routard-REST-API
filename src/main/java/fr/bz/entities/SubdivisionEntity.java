package fr.bz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "SUBDIVISION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubdivisionEntity {
    @Id
    @Column(name = "ID_SUBDIVISION")
    private int idSubdivision;
    @Column(name = "CODE_ISO_3166_2")
    private String codeIso31662;
    @Column(name = "NOM_SUBDIVISION")
    private String nomSubdivision;
    @ManyToOne
    @JoinColumn(name = "ID_TYPE", referencedColumnName = "ID_TYPE")
    private TypeSubdivisionEntity typeSubdivision;
    @ManyToOne
    @JoinColumn(name = "CODE_ISO_3166_1", referencedColumnName = "CODE_ISO_3166_1")
    private PaysEntity pays;
}
