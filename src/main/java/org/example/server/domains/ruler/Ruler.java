package org.example.server.domains.ruler;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import lombok.*;
import org.example.server.domains.country.Country;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@JsonSerialize
public class Ruler implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Getter
  private Long id;

  @Column(name = "name")
  @Getter
  private String name;

  @Column(name = "surname")
  @Getter
  private String surname;

  @Column(name = "office_start_date")
  @Getter
  private Date officeStartDate;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "country_id", referencedColumnName = "id")
  private Country country;
}
