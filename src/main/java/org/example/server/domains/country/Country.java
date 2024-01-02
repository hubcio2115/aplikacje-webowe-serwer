package org.example.server.domains.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Year;
import lombok.*;
import org.example.server.domains.ruler.Ruler;

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
  @JsonProperty("isInEurope")
  private boolean isInEurope;

  @Column(name = "formation_year")
  private Year formationYear;

  @OneToOne(fetch = FetchType.LAZY, optional = true)
  private Ruler ruler;
}
