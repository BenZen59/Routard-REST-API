package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;

@Entity(name="POINT_INTERET")
@Getter
public class PointInteretEntity {
    @Id
    @Column(name = "ID_POINT_INTERET")
    private int idPointInteret;
    @Column(name = "NOM_POINT_INTERET")
    private String nomPointInteret;
    @OneToMany(mappedBy = "pointInteret")
    private List<CategoriserEntity> categoriserEntityList;
}
