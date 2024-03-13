package fr.bz.entities;

import io.quarkus.arc.All;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "CONTINENT")
@Getter
@Setter
@AllArgsConstructor
public class ContinentEntity {
    @Id
    @Column(name = "CODE_CONTINENT")
    private String codeContinent;
    @Column(name = "NOM_CONTINENT")
    private String nomContinent;


    public ContinentEntity() {

    }
}
