package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.List;

@Entity(name = "MOIS")
@Getter

public class MoisEntity {
    @Id
    @Column(name = "ID_MOIS")
    private int idMois;
    @Column(name = "NOM_MOIS")
    private String nomLangue;
    @OneToMany(mappedBy = "mois")
    @Getter(AccessLevel.NONE)
    private List<TempererEntity> tempererEntityList;
}

