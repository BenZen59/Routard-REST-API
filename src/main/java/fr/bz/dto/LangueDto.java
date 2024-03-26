package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.LangueEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LangueDto {
    @JsonProperty(index = 1)
    private String isoLangue;
    @JsonProperty(index = 2)
    private String nomLangue;

    public LangueDto(LangueEntity langueEntity) {
        isoLangue = langueEntity.getIsoLangue();
        nomLangue = langueEntity.getNomLangue();
    }

   /* public static List<LangueDto> toDtoList(List<LangueEntity> langueEntities) {
        List<LangueDto> langueDtoList = new ArrayList<>();
        for (LangueEntity langueEntity : langueEntities)
            langueDtoList.add(new LangueDto(langueEntity));
        return langueDtoList;
    }*/
}
