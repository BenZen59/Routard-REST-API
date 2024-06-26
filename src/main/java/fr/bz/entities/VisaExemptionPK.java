package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Embeddable
public class VisaExemptionPK implements Serializable {

    @Column(name="CODE_PAYS", columnDefinition = "CHAR(2)")
    private String codePays;

    @Column(name="CODE_PAYS_EXEMPTE", columnDefinition = "CHAR(2)")
    private String codePaysExempted;
}
