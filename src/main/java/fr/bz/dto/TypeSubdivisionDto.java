package fr.bz.dto;

import fr.bz.entities.TypeSubdivisionEntity;
import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class TypeSubdivisionDto {
    @Column(name = "ID_TYPE")
    private int idType;
    @Column(name = "NOM_TYPE_SUBDIVISION")
    private String nomTypeSubdivision;

    public TypeSubdivisionDto(TypeSubdivisionEntity typeSubdivisionEntity){
        idType = typeSubdivisionEntity.getIdType();
        nomTypeSubdivision = typeSubdivisionEntity.getNomTypeSubdivision();
    }
}
