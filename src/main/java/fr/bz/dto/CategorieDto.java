package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.CategorieEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CategorieDto {
    @JsonProperty(index = 1)
    private int idCategorie;
    @JsonProperty(index = 2)
    private String nomCategorie;

    public CategorieDto(CategorieEntity categorieEntity) {
        idCategorie = categorieEntity.getIdCategorie();
        nomCategorie = categorieEntity.getNomCategorie();
    }

    public static List<CategorieDto> toDtoList(List<CategorieEntity> categorieEntities) {
        List<CategorieDto> categorieDtoList = new ArrayList<>();
        for (CategorieEntity categorieEntity : categorieEntities)
            categorieDtoList.add(new CategorieDto(categorieEntity));
        return categorieDtoList;
    }
}
