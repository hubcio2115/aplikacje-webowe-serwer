package org.example.springguide.domains;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RulerRepository extends JpaRepository<Ruler, Long> {
}
