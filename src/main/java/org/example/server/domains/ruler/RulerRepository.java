package org.example.server.domains.ruler;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RulerRepository extends JpaRepository<Ruler, Long> {
  Optional<Ruler> findByCountryId(long countryId);
}
