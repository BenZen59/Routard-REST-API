package fr.bz.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="PAYS_FORMALITE_EXIGENCE")
public class PaysFormaliteExigence {
    @EmbeddedId
    private PaysFormalitePK paysFormalitePK;
}
