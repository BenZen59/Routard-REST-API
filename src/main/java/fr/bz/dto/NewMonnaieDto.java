package fr.bz.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class NewMonnaieDto {
    @Id
    @Column(name = "CODE_ISO_MONNAIE")
    private String codeIsoMonnaie;
    @Column(name = "NOM_DEVISE")
    private String nomDevise;
}
