package fr.bz.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity(name = "CATEGORISER")
@Getter
public class CategoriserEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    private CategorieEntity categorie;
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_POINT_INTERET", referencedColumnName = "ID_POINT_INTERET")
    private PointInteretEntity pointInteret;
}
