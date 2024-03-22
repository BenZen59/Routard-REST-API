package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.PaysEntity;
import fr.bz.entities.SubdivisionEntity;
import fr.bz.entities.TypeSubdivisionEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubdivisionByPaysDto {
    @JsonProperty(index = 1)
    private int idSubdivision;
    @JsonProperty(index = 2)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String codeIso31662;
    @JsonProperty(index = 3)
    private String nomSubdivision;
    @JsonProperty(index = 4)
    private TypeSubdivisionEntity typeSubdivision;

    public SubdivisionByPaysDto(SubdivisionEntity subdivisionEntity) {
        idSubdivision = subdivisionEntity.getIdSubdivision();
        if (subdivisionEntity.getCodeIso31662() != null)
            codeIso31662 = subdivisionEntity.getCodeIso31662();
        nomSubdivision = subdivisionEntity.getNomSubdivision();
        typeSubdivision = subdivisionEntity.getTypeSubdivision();
    }

    public static List<SubdivisionByPaysDto> toDtoList(List<SubdivisionEntity> subdivisionEntities) {
        List<SubdivisionByPaysDto> subdivisionByPaysDtoList = new ArrayList<>();
        for (SubdivisionEntity subdivisionEntity : subdivisionEntities)
            subdivisionByPaysDtoList.add(new SubdivisionByPaysDto(subdivisionEntity));
        return subdivisionByPaysDtoList;
    }
}
