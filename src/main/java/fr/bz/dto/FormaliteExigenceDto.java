package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.FormaliteExigenceEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FormaliteExigenceDto {

    @JsonProperty(index = 1)
    private String formalite;

    @JsonProperty(index = 2)
    private String type;

    @JsonProperty(index = 3)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    private String notes;

    @JsonProperty(index = 4)
    private String statut;

    public FormaliteExigenceDto(FormaliteExigenceEntity formaliteExigenceEntity) {
       this.formalite = formaliteExigenceEntity.getFormaliteEntree().getNomFormalite();
       this.type = formaliteExigenceEntity.getFormaliteEntree().getTypeFormalite().getNomTypeFormalite();
       this.statut = formaliteExigenceEntity.getExigenceStatut().getNomStatut();
       this.notes = formaliteExigenceEntity.getNotes();
    }

    public static List<FormaliteExigenceDto> getDtoList(List<FormaliteExigenceEntity> formaliteExigenceEntities) {
        ArrayList<FormaliteExigenceDto> dtos = new ArrayList<>();

        for(FormaliteExigenceEntity formaliteExigenceEntity : formaliteExigenceEntities)
            dtos.add(new FormaliteExigenceDto(formaliteExigenceEntity));

        return dtos;
    }

}
