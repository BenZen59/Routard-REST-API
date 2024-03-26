package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.TypeClimatEntity;
import fr.bz.entities.VilleEntity;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class VilleDto {
    @JsonProperty(index = 1)
    private int idVille;
    @JsonProperty(index = 2)
    private String nomVille;
    @JsonProperty(index = 5)
    private SubdivisionDto subdivision;
    @JsonProperty(index = 6)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TypeClimatDto typeClimat;

    public VilleDto(VilleEntity villeEntity) {
        idVille = villeEntity.getIdVille();
        nomVille = villeEntity.getNomVille();
        subdivision = new SubdivisionDto(villeEntity.getSubdivision());
        if(villeEntity.getTypeClimat() != null)
            typeClimat = new TypeClimatDto(villeEntity.getTypeClimat());
    }

    public static List<VilleDto> toDtoList(List<VilleEntity> villeEntities) {
        List<VilleDto> villeDtoList = new ArrayList<>();
        for (VilleEntity villeEntity : villeEntities)
            villeDtoList.add(new VilleDto(villeEntity));
        return villeDtoList;
    }
}
