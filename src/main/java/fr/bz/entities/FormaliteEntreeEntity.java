package fr.bz.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity(name="FORMALITE_ENTREE")
public class FormaliteEntreeEntity {
    @Id
    @Column(name="ID_FORMALITE")
    private Integer idFormalite;
    @Column(name="NOM_FORMALITE")
    private String nomFormalite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_TYPE")
    private TypeFormaliteEntity typeFormalite;
}
