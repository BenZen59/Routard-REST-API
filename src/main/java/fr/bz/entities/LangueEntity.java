package fr.bz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "LANGUE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LangueEntity {
    @Id
    @Column(name = "ISO_LANGUE")
    private String isoLangue;
    @Column(name = "NOM_LANGUE")
    private String nomLangue;
}
