package fr.bz.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class NewPaysDto {
    @Id
    @Column(name = "CODE_ISO_3166_1")
    private String codeIso31661;
    @Column(name = "NOM_PAYS")
    private String nomPays;
    @Column(name = "CODE_CONTINENT")
    private String codeContinent;

}
