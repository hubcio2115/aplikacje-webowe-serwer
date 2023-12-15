package org.example.springguide.domains;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class Ruler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "office_start_date")
    private Date officeStartDate;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    public Ruler(String name, String surname, Date officeStartDate) {
        this.name = name;
        this.surname = surname;
        this.officeStartDate = officeStartDate;
    }

    public Ruler() {
    }
}
