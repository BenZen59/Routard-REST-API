package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.PaysEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PaysDto {
    @JsonProperty(index=1)
    private String codeIso31661;
    @JsonProperty(index=2)
    private String nomPays;
    @JsonProperty(index=3)
    private ContinentDto continent;

    public PaysDto(PaysEntity paysEntity){
        codeIso31661 = paysEntity.getCodeIso31661();
        nomPays = paysEntity.getNomPays();
        continent = new ContinentDto(paysEntity.getContinent());

    }

    public static List<PaysDto> toDtoList(List<PaysEntity> paysEntities){
        List<PaysDto> paysDtoList = new ArrayList<>();
        for(PaysEntity paysEntity : paysEntities)
            paysDtoList.add(new PaysDto(paysEntity));
        return paysDtoList;
    }
}
