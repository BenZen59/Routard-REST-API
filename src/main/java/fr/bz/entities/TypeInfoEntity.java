package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.List;

@Entity(name = "TYPE_INFO")
@Getter
public class TypeInfoEntity {
    @Id
    @Column(name = "ID_TYPE_INFO")
    private int idTypeInfo;
    @Column(name = "NOM_TYPE_INFO")
    private String nomTypeInfo;
    @OneToMany(mappedBy = "typeInfo")
    @Getter(AccessLevel.NONE)
    private List<InformerEntity> informerEntityList;
}
