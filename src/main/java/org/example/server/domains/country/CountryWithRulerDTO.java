package org.example.server.domains.country;

import org.example.server.domains.ruler.RulerDTO;

import java.io.Serializable;
import java.time.Year;
import java.util.Optional;

public record CountryWithRulerDTO(
    String name, long gdp, boolean isInEurope, Year formationYear, Optional<RulerDTO> ruler)
    implements Serializable {}
