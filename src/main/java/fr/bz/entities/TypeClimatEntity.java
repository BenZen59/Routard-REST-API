package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "TYPE_CLIMAT")
@Getter
public class TypeClimatEntity {
    @Id
    @Column(name = "CODE_CLIMAT")
    private String codeClimat;
    @Column(name = "NOM_TYPE_CLIMAT")
    private String nomTypeClimat;
}
