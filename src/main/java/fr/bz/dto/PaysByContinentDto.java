package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.PaysEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PaysByContinentDto {
    @JsonProperty(index = 1)
    private String codeIso31661;
    @JsonProperty(index = 2)
    private String nomPays;

    public PaysByContinentDto(PaysEntity paysEntity) {
        codeIso31661 = paysEntity.getCodeIso31661();
        nomPays = paysEntity.getNomPays();
    }

    public static List<PaysByContinentDto> toDtoList(List<PaysEntity> paysEntities) {
        List<PaysByContinentDto> paysDtoList = new ArrayList<>();
        for (PaysEntity paysEntity : paysEntities)
            paysDtoList.add(new PaysByContinentDto(paysEntity));
        return paysDtoList;
    }
}
