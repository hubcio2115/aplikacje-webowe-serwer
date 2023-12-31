package org.example.springguide.domains;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Year;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gdp")
    private long gdp;
    @Column(name = "is_in_europe")
    private boolean isInEurope;
    @Column(name = "formation_year")
    private Year formationYear;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    private Ruler ruler;
}
