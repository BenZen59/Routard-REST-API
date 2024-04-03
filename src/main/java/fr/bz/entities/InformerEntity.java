package fr.bz.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;

@Entity(name = "INFORMER")
@Getter
public class InformerEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_TYPE_INFO", referencedColumnName = "ID_TYPE_INFO")
    private TypeInfoEntity typeInfo;
    @Id
    @ManyToOne
    @JoinColumn(name = "CODE_ISO_3166_1", referencedColumnName = "CODE_ISO_3166_1")
    @Getter(AccessLevel.NONE)
    private PaysEntity pays;
    @Column(name = "INFO")
    private String info;


}
