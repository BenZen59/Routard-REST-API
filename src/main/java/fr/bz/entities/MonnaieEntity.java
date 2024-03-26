package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "MONNAIE")
@Getter
public class MonnaieEntity {
    @Id
    @Column(name = "CODE_ISO_MONNAIE")
    private String codeIsoMonnaie;
    @Column(name = "NOM_DEVISE")
    private String nomDevise;
}
