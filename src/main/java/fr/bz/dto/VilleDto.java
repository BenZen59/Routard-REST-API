package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.TypeClimatEntity;
import fr.bz.entities.VilleEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VilleDto {
    @JsonProperty(index = 1)
    private int idVille;
    @JsonProperty(index = 2)
    private String nomVille;
    @JsonProperty(index = 5)
    private SubdivisionDto subdivision;
    @JsonProperty(index = 6)
    @JsonInclude(JsonInclude.Include.NON_NULL)

    private TypeClimatEntity typeClimat;

    public VilleDto(VilleEntity villeEntity) {
        idVille = villeEntity.getIdVille();
        nomVille = villeEntity.getNomVille();
        subdivision = new SubdivisionDto(villeEntity.getSubdivision());
    }

    public static List<VilleDto> toDtoList(List<VilleEntity> villeEntities) {
        List<VilleDto> villeDtoList = new ArrayList<>();
        for (VilleEntity villeEntity : villeEntities)
            villeDtoList.add(new VilleDto(villeEntity));
        return villeDtoList;
    }
}
