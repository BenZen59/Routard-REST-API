package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "CONTINENT")
@Getter
@Setter
public class ContinentEntity {
    @Id
    @Column(name = "CODE_CONTINENT")
    private String codeContinent;
    @Column(name = "NOM_CONTINENT")
    private String nomContinent;
}
