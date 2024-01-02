package org.example.server.domains.country;

import jakarta.persistence.*;
import lombok.*;
import org.example.server.domains.ruler.Ruler;

import java.io.Serializable;
import java.time.Year;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Country implements Serializable {
  @Getter
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
