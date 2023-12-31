package org.example.springguide.domains;

import java.io.Serializable;
import java.time.Year;

public record CountryDTO(
        String name,
        long gdp,
        boolean isInEurope,
        Year formationYear
        ) implements Serializable {
}
