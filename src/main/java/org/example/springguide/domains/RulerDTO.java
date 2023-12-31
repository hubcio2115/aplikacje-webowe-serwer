package org.example.springguide.domains;

import java.sql.Date;

public record RulerDTO(
        String name,
        String surname,
        Date officeStartDate
) {
}
