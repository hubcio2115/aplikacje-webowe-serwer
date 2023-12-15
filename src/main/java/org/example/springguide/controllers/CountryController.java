package org.example.springguide.controllers;

import org.example.springguide.domains.Country;
import org.example.springguide.domains.CountryDTO;
import org.example.springguide.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    ResponseEntity<List<Country>> getCountries() {
        return ResponseEntity.ok(this.countryService.getCountries());
    }

    @GetMapping(":id")
    ResponseEntity<Optional<Country>> getCountryById(@RequestParam long id) {
        return ResponseEntity.ok(this.countryService.getById(id));
    }

    @PostMapping
    ResponseEntity<Country> addCountry(@RequestBody CountryDTO newCountry) {
        return ResponseEntity.ok(this.countryService.addCountry(newCountry));
    }

    @DeleteMapping(":id")
    ResponseEntity<Optional<Country>> deleteCountry(@RequestParam long id) {
        var deletedCountry = this.countryService.deleteById(id);

        if (deletedCountry.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(deletedCountry);
    }
}
