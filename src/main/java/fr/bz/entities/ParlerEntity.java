package fr.bz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PARLER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParlerEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "ISO_LANGUE", referencedColumnName = "ISO_LANGUE")
    private LangueEntity langue;
    @Id
    @ManyToOne
    @JoinColumn(name = "CODE_ISO_3166_1", referencedColumnName = "CODE_ISO_3166_1")
    private PaysEntity pays;
}
