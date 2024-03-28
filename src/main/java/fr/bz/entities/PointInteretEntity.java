package fr.bz.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity(name = "POINT_INTERET")
@Getter
public class PointInteretEntity {
    @Id
    @Column(name = "ID_POINT_INTERET")
    private int idPointInteret;
    @Column(name = "NOM_POINT_INTERET")
    private String nomPointInteret;
    @OneToMany(mappedBy = "pointInteret")
    private List<CategoriserEntity> categoriserEntityList;
    @OneToMany(mappedBy = "pointInteret")
    private List<AvoirEntity> avoirEntityList;
}
