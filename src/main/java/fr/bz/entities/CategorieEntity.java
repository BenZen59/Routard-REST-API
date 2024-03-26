package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity(name = "CATEGORIE")
@Getter
public class CategorieEntity {
    @Id
    @Column(name = "ID_CATEGORIE")
    private int idCategorie;
    @Column(name = "NOM_CATEGORIE")
    private String nomCategorie;
}
