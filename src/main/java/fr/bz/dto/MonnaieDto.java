package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.ContinentEntity;
import fr.bz.entities.MonnaieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MonnaieDto {
    @JsonProperty(index = 1)
    private String codeIsoMonnaie;
    @JsonProperty(index = 2)
    private String nomDevise;

    public MonnaieDto(MonnaieEntity monnaieEntity) {
        codeIsoMonnaie = monnaieEntity.getCodeIsoMonnaie();
        nomDevise = monnaieEntity.getNomDevise();
    }

    public static List<MonnaieDto> toDtoList(List<MonnaieEntity> monnaieEntities) {
        List<MonnaieDto> monnaieDtoList = new ArrayList<>();
        for (MonnaieEntity monnaieEntity : monnaieEntities)
            monnaieDtoList.add(new MonnaieDto(monnaieEntity));
        return monnaieDtoList;
    }
}
