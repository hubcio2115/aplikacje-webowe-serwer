package org.example.springguide.domains;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Year;

@Entity
@Table
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

    public Country() {
    }

    public Country(String name, long gdp, Year formationYear, boolean isInEurope) {
        this.name = name;
        this.isInEurope = isInEurope;
        this.gdp = gdp;
        this.formationYear = formationYear;
    }


    public long getId() {
        return id;
    }

    public long getGdp() {
        return gdp;
    }

    public void setGdp(long gdp) {
        this.gdp = gdp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsInEurope() {
        return isInEurope;
    }

    public void setIsInEurope(boolean isInEurope) {
        this.isInEurope = isInEurope;
    }

    public Year getFormationYear() {
        return formationYear;
    }

    public void setFormationYear(Year formationYear) {
        this.formationYear = formationYear;
    }

    public Ruler getRuler() {
        return this.ruler;
    }
}
