package org.example.springguide.domains;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class Ruler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Ruler(String name, String surname, Date officeStartDate) {
        this.name = name;
        this.surname = surname;
        this.officeStartDate = officeStartDate;
    }

    public Ruler() {
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getOfficeStartDate() {
        return officeStartDate;
    }

    public void setOfficeStartDate(Date officeStartDate) {
        this.officeStartDate = officeStartDate;
    }
}
