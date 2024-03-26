package fr.bz.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;

@Entity(name = "AVOIR")
@Getter
public class AvoirEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_POINT_INTERET", referencedColumnName = "ID_POINT_INTERET")
    private PointInteretEntity pointInteret;
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_SUBDIVISION", referencedColumnName = "ID_SUBDIVISION")
    private SubdivisionEntity subdivision;
}
