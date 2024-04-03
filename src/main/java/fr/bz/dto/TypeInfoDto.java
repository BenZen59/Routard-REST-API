package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.TypeInfoEntity;
import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class TypeInfoDto {
    @JsonProperty(index = 1)
    private int idTypeInfo;
    @JsonProperty(index = 2)
    private String nomTypeInfo;

    public TypeInfoDto(TypeInfoEntity typeInfoEntity) {
        idTypeInfo = typeInfoEntity.getIdTypeInfo();
        nomTypeInfo = typeInfoEntity.getNomTypeInfo();
    }
}
