package fr.bz.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class NewLangueDto {
    @Id
    @Column(name = "ISO_LANGUE")
    private String isoLangue;
    @Column(name = "NOM_LANGUE")
    private String nomLangue;
}
