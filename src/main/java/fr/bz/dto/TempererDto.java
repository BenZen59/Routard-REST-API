package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.MoisEntity;
import fr.bz.entities.TempererEntity;
import fr.bz.entities.VilleEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TempererDto {
    @JsonProperty(index = 1)
    private MoisDto mois;
    @JsonProperty(index = 2)
    private VilleDto ville;
    @JsonProperty(index = 3)
    private float temperatureMoyenne;
    @JsonProperty(index = 4)
    private int humiditeMoyenne;
    @JsonProperty(index = 5)
    private float precipitationMoyenne;


    public TempererDto(TempererEntity tempererEntity) {
        mois = new MoisDto(tempererEntity.getMois());
        ville = new VilleDto(tempererEntity.getVille());
        temperatureMoyenne = tempererEntity.getTemperatureMoyenne();
        humiditeMoyenne = tempererEntity.getHumiditeMoyenne();
        precipitationMoyenne = tempererEntity.getPrecipitationMoyenne();
    }

    public static List<VilleDto> toDtoList(List<VilleEntity> villeEntities) {
        List<VilleDto> villeDtoList = new ArrayList<>();
        for (VilleEntity villeEntity : villeEntities)
            villeDtoList.add(new VilleDto(villeEntity));
        return villeDtoList;
    }
}
