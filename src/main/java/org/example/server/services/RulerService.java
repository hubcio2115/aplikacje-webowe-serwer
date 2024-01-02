package org.example.server.services;

import org.example.server.domains.country.Country;
import org.example.server.domains.ruler.Ruler;
import org.example.server.domains.ruler.RulerDTO;
import org.example.server.domains.ruler.RulerRepository;
import org.springframework.stereotype.Service;
import lombok.val;

import java.util.Optional;

@Service
public class RulerService {
  private final RulerRepository rulerRepository;

  public RulerService(RulerRepository rulerRepository) {
    this.rulerRepository = rulerRepository;
  }

  private Optional<Ruler> getById(long id) {
    return this.rulerRepository.findById(id);
  }

  public Optional<Ruler> addRuler(RulerDTO ruler, Country country) {
    val newRuler =
        Ruler.builder()
            .name(ruler.name())
            .surname(ruler.surname())
            .officeStartDate(ruler.officeStartDate())
            .country(country)
            .build();

    return Optional.of(this.rulerRepository.save(newRuler));
  }

  public void deleteById(long id) {
    val ruler = this.getById(id);

    if (ruler.isEmpty()) return;

    this.rulerRepository.deleteById(id);
  }

  public Optional<Ruler> getRulerByCountryId(long countryId) {
    return this.rulerRepository.findByCountryId(countryId);
  }

  public Optional<Ruler> updateRulerById(long rulerId, RulerDTO ruler) {
    val rulerFromDb = this.rulerRepository.findById(rulerId);
    if (rulerFromDb.isEmpty()) return Optional.empty();

    val updatedRuler = rulerFromDb.get();

    updatedRuler.setName(ruler.name());
    updatedRuler.setSurname(ruler.surname());
    updatedRuler.setOfficeStartDate(ruler.officeStartDate());

    return Optional.of(this.rulerRepository.save(updatedRuler));
  }
}
