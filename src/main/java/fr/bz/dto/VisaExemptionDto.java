package fr.bz.dto;

import fr.bz.entities.VisaExemptionEntity;
import fr.bz.entities.VisaExemptionPK;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class VisaExemptionDto {
    private String codePays;
    private String nomPays;
    private int dureeMin;
    private int dureeMax;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public VisaExemptionDto(VisaExemptionEntity visaExemptionEntity) {
        this.codePays = visaExemptionEntity.getPaysExempte().getCodeIso31661();
        this.nomPays = visaExemptionEntity.getPaysExempte().getNomPays();
        this.dureeMin = visaExemptionEntity.getDureeMin();
        this.dureeMax = visaExemptionEntity.getDureeMax();
        this.dateDebut = visaExemptionEntity.getDateDebut();
        this.dateFin = visaExemptionEntity.getDateFin();
    }

    public static List<VisaExemptionDto> getDtos(List<VisaExemptionEntity> visaExemptionEntities) {
        ArrayList<VisaExemptionDto> dtos = new ArrayList<>();

        for(VisaExemptionEntity visaExemptionEntity : visaExemptionEntities)
            dtos.add(new VisaExemptionDto(visaExemptionEntity));

        return dtos;
    }

}
