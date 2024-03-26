package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.TypeClimatEntity;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TypeClimatDto {
    @JsonProperty(index = 1)
    private String codeClimat;
    @JsonProperty(index = 2)
    private String nomTypeClimat;

    public TypeClimatDto(TypeClimatEntity typeClimatEntity) {
        codeClimat = typeClimatEntity.getCodeClimat();
        nomTypeClimat = typeClimatEntity.getNomTypeClimat();
    }

}
