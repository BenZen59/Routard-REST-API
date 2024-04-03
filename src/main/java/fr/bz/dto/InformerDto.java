package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.InformerEntity;
import fr.bz.entities.PaysEntity;
import fr.bz.entities.TempererEntity;
import fr.bz.entities.TypeInfoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

public class InformerDto {
    @JsonProperty(index = 1)
    private TypeInfoDto typeInfo;
    @JsonProperty(index = 2)
    private String info;

    public InformerDto(InformerEntity informerEntity) {
        typeInfo = new TypeInfoDto(informerEntity.getTypeInfo());
        info = informerEntity.getInfo();
    }

    public static List<InformerDto> toDtoList(List<InformerEntity> informerEntities) {
        List<InformerDto> informerDtoList = new ArrayList<>();
        for (InformerEntity informerEntity : informerEntities)
            informerDtoList.add(new InformerDto(informerEntity));
        return informerDtoList;
    }
}

