package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.ContinentEntity;
import fr.bz.entities.PaysEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ContinentDto {
    @JsonProperty(index = 1)
    private String codeContinent;
    @JsonProperty(index = 2)
    private String nomContinent;

    public ContinentDto(ContinentEntity continentEntity) {
        codeContinent = continentEntity.getCodeContinent();
        nomContinent = continentEntity.getNomContinent();
    }

    public static List<ContinentDto> toDtoList(List<ContinentEntity> continentEntities) {
        List<ContinentDto> continentDtoList = new ArrayList<>();
        for (ContinentEntity continentEntity : continentEntities)
            continentDtoList.add(new ContinentDto(continentEntity));
        return continentDtoList;
    }
}
