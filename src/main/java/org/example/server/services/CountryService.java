package org.example.server.services;

import org.example.server.domains.country.Country;
import org.example.server.domains.country.CountryDTO;
import org.example.server.domains.country.CountryRepository;
import org.springframework.stereotype.Service;
import lombok.val;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
  private final CountryRepository countryRepository;
  private final RulerService rulerService;

  public CountryService(CountryRepository countryRepository, RulerService rulerService) {
    this.countryRepository = countryRepository;
    this.rulerService = rulerService;
  }

  public List<Country> getCountries() {
    return this.countryRepository.findAll();
  }

  public Optional<Country> getById(long id) {
    return this.countryRepository.findById(id);
  }

  public Country addCountry(CountryDTO country) {
    val newCountry =
        Country.builder()
            .name(country.name())
            .gdp(country.gdp())
            .formationYear(country.formationYear())
            .isInEurope(country.isInEurope())
            .build();

    return this.countryRepository.save(newCountry);
  }

  public Optional<Country> deleteById(long id) {
    val country = this.getById(id);
    if (country.isEmpty()) return Optional.empty();

    val ruler = this.rulerService.getRulerByCountryId(id);
    ruler.ifPresent(value -> this.rulerService.deleteById(value.getId()));

    this.countryRepository.deleteById(id);

    return country;
  }

  public Optional<Country> updateCountryById(long id, CountryDTO country) {
    val countryFromDb = this.countryRepository.findById(id);
    if (countryFromDb.isEmpty()) return Optional.empty();

    val updatedCountry = countryFromDb.get();

    updatedCountry.setName(country.name());
    updatedCountry.setGdp(country.gdp());
    updatedCountry.setFormationYear(country.formationYear());
    updatedCountry.setInEurope(country.isInEurope());

    return Optional.of(this.countryRepository.save(updatedCountry));
  }
}
