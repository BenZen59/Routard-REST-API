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
    @JoinColumn(name = "ID_POINT_INTERET", referencedColumnName = "ID_POINT_INTERET")
    private PointInteretEntity pointInteret;
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_SUBDIVISION", referencedColumnName = "ID_SUBDIVISION")
    private SubdivisionEntity subdivision;
}
