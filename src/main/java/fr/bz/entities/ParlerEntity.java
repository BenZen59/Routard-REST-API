package fr.bz.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "PARLER")
@Getter
public class ParlerEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "ISO_LANGUE", referencedColumnName = "ISO_LANGUE")
    private LangueEntity langue;
    @Id
    @ManyToOne
    @JoinColumn(name = "CODE_ISO_3166_1", referencedColumnName = "CODE_ISO_3166_1")
    @Getter(AccessLevel.NONE)
    private PaysEntity pays;
}
