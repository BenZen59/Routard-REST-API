package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "MONNAIE")
@Getter
@Setter
public class MonnaieEntity {
    @Id
    @Column(name = "CODE_ISO_MONNAIE")
    private String codeIsoMonnaie;
    @Column(name = "NOM_DEVISE")
    private String nomDevise;
}
