package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TYPE_SUBDIVISION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeSubdivisionEntity {
    @Id
    @Column(name = "ID_TYPE")
    private int idType;
    @Column(name = "NOM_TYPE_SUBDIVISION")
    private String nomTypeSubdivision;
}
