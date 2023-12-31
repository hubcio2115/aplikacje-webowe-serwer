package org.example.springguide.domains;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RulerRepository extends JpaRepository<Ruler, Long> {
    Optional<Ruler> findByCountryId(long countryId);
}
