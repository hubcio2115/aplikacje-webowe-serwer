package org.example.springguide.services;

import org.example.springguide.domains.Country;
import org.example.springguide.domains.CountryDTO;
import org.example.springguide.domains.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(
            CountryRepository countryRepository
    ) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries() {
        return this.countryRepository.findAll();
    }

    public Optional<Country> getById(long id) {
        return this.countryRepository.findById(id);
    }

    public Country addCountry(CountryDTO country) {
        var newCountry = new Country(country.name(), country.gdp(), country.formationYear(), country.isInEurope());
        return this.countryRepository.save(newCountry);
    }

    public Optional<Country> deleteById(long id) {
        var country = this.countryRepository.findById(id);
        if (country.isEmpty())
           return Optional.empty();

        this.countryRepository.deleteById(id);
        return country;
    }
}
