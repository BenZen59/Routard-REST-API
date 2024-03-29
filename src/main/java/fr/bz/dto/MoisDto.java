package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.MoisEntity;
import lombok.Getter;

@Getter
public class MoisDto {
    @JsonProperty(index = 1)
    private int idMois;
    @JsonProperty(index = 2)
    private String nomMois;

    public MoisDto(MoisEntity moisEntity) {
        idMois = moisEntity.getIdMois();
        nomMois = moisEntity.getNomLangue();
    }
}
