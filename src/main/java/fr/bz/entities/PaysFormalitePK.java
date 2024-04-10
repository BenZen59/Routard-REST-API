package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Embeddable
public class PaysFormalitePK implements Serializable {
    @Column(name="CODE_PAYS", columnDefinition = "CHAR(2)")
    private String codePays;
    @Column(name="ID_FORMALITE")
    private Integer idFormalite;
}
