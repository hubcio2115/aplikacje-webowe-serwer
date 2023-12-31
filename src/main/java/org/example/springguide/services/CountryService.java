package org.example.springguide.services;

import org.example.springguide.domains.Country;
import org.example.springguide.domains.CountryDTO;
import org.example.springguide.domains.CountryRepository;
import org.example.springguide.domains.RulerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    private final RulerService rulerService;

    public CountryService(
            CountryRepository countryRepository,
            RulerService rulerService
    ) {
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
        var newCountry = new Country(country.name(), country.gdp(), country.formationYear(), country.isInEurope());

        System.out.println(newCountry);

        return this.countryRepository.save(newCountry);
    }

    public Optional<Country> deleteById(long id) {
        var country = this.getById(id);
        if (country.isEmpty())
            return Optional.empty();

        var ruler = this.rulerService.getRulerByCountryId(id);
        ruler.ifPresent(value -> this.rulerService.deleteById(value.getId()));

        this.countryRepository.deleteById(id);

        return country;
    }

    public Optional<Country> updateCountryById(long id, CountryDTO country) {
        var countryFromDb = this.countryRepository.findById(id);
        if (countryFromDb.isEmpty()) return Optional.empty();

        var updatedCountry = countryFromDb.get();

        updatedCountry.setName(country.name());
        updatedCountry.setGdp(country.gdp());
        updatedCountry.setFormationYear(country.formationYear());
        updatedCountry.setIsInEurope(country.isInEurope());

        return Optional.of(
                this.countryRepository.save(updatedCountry)
        );
    }
}
