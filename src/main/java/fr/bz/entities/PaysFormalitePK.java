package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PaysFormalitePK implements Serializable {
    @Column(name="CODE_PAYS")
    String codePays;
    @Column(name="ID_FORMALITE")
    Integer idFormalite;
}
