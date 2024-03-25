package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TYPE_CLIMAT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeClimatEntity {
    @Id
    @Column(name = "CODE_CLIMAT")
    private String codeClimat;
    @Column(name = "NOM_TYPE_CLIMAT")
    private String nomTypeClimat;
}
