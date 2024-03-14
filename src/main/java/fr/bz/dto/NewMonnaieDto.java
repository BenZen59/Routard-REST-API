package fr.bz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bz.entities.ContinentEntity;
import fr.bz.entities.MonnaieEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class NewMonnaieDto {
    @Id
    @Column(name = "CODE_ISO_MONNAIE")
    private String codeIsoMonnaie;
    @Column(name = "NOM_DEVISE")
    private String nomDevise;
}
