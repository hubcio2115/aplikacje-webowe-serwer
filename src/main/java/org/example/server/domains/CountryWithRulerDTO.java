package org.example.server.domains;

import java.io.Serializable;
import java.time.Year;
import java.util.Optional;

public record CountryWithRulerDTO(
        String name,
        long gdp,
        boolean isInEurope,
        Year formationYear,
        Optional<RulerDTO> ruler
) implements Serializable {
}
