package org.example.server.domains;

import java.sql.Date;

public record RulerDTO(
        String name,
        String surname,
        Date officeStartDate
) {
}
