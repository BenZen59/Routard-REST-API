package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "LANGUE")
@Getter

public class LangueEntity {
    @Id
    @Column(name = "ISO_LANGUE", columnDefinition = "CHAR(2)")
    private String isoLangue;
    @Column(name = "NOM_LANGUE")
    private String nomLangue;
}
