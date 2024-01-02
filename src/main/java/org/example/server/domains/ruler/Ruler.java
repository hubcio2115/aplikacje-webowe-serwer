package org.example.server.domains.ruler;

import jakarta.persistence.*;
import lombok.*;
import org.example.server.domains.country.Country;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Ruler implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "office_start_date")
  private Date officeStartDate;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "country_id", referencedColumnName = "id")
  private Country country;
}
