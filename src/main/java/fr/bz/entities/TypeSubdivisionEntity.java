package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "TYPE_SUBDIVISION")
@Getter

public class TypeSubdivisionEntity {
    @Id
    @Column(name = "ID_TYPE")
    private int idType;
    @Column(name = "NOM_TYPE_SUBDIVISION")
    private String nomTypeSubdivision;
}
