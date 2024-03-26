package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.SubdivisionEntity;
import fr.bz.entities.TypeSubdivisionEntity;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SubdivisionDto {
    @JsonProperty(index = 1)
    private int idSubdivision;
    @JsonProperty(index = 2)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String codeIso31662;
    @JsonProperty(index = 3)
    private String nomSubdivision;
    @JsonProperty(index = 4)
    private TypeSubdivisionEntity typeSubdivision;

    public SubdivisionDto(SubdivisionEntity subdivisionEntity) {
        idSubdivision = subdivisionEntity.getIdSubdivision();
        if (subdivisionEntity.getCodeIso31662() != null)
            codeIso31662 = subdivisionEntity.getCodeIso31662();
        nomSubdivision = subdivisionEntity.getNomSubdivision();
        typeSubdivision = subdivisionEntity.getTypeSubdivision();
    }

    public static List<SubdivisionDto> toDtoList(List<SubdivisionEntity> subdivisionEntities) {
        List<SubdivisionDto> subdivisionByPaysDtoList = new ArrayList<>();
        for (SubdivisionEntity subdivisionEntity : subdivisionEntities)
            subdivisionByPaysDtoList.add(new SubdivisionDto(subdivisionEntity));
        return subdivisionByPaysDtoList;
    }
}
