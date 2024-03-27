package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.CategoriserEntity;
import fr.bz.entities.PointInteretEntity;
import fr.bz.entities.VilleEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PointInteretDto {
    @JsonProperty(index = 1)
    private int idPointInteret;
    @JsonProperty(index = 2)
    private String nomPointInteret;
    @JsonProperty(index = 3)
    private List<CategorieDto> categories;

    public PointInteretDto(PointInteretEntity pointInteretEntity) {
        idPointInteret = pointInteretEntity.getIdPointInteret();
        nomPointInteret = pointInteretEntity.getNomPointInteret();
        categories = pointInteretEntity.getCategoriserEntityList().stream().map(CategoriserEntity::getCategorie).map(CategorieDto::new).collect(Collectors.toList());
    }

    public static List<PointInteretDto> toDtoList(List<PointInteretEntity> pointInteretEntities) {
        List<PointInteretDto> pointInteretDtoList = new ArrayList<>();
        for (PointInteretEntity pointInteretEntity : pointInteretEntities)
            pointInteretDtoList.add(new PointInteretDto(pointInteretEntity));
        return pointInteretDtoList;
    }
}

