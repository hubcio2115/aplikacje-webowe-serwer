package org.example.server.controllers;

import lombok.RequiredArgsConstructor;
import org.example.server.domains.country.Country;
import org.example.server.domains.country.CountryDTO;
import org.example.server.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.val;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/countries")
@RequiredArgsConstructor
public class CountryController {
  private final CountryService countryService;

  @GetMapping
  ResponseEntity<List<Country>> getCountries() {
    return ResponseEntity.ok(this.countryService.getCountries());
  }

  @GetMapping("{id}")
  ResponseEntity<Country> getCountryById(@PathVariable long id) {
    val country = this.countryService.getById(id);

    return country.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  ResponseEntity<Country> addCountry(@RequestBody CountryDTO newCountry) {
    return ResponseEntity.ok(this.countryService.addCountry(newCountry));
  }

  @DeleteMapping("{id}")
  ResponseEntity<Country> deleteCountry(@PathVariable long id) {
    val deletedCountry = this.countryService.deleteById(id);

    return deletedCountry
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping("{id}")
  ResponseEntity<Country> updateCountry(@PathVariable long id, @RequestBody CountryDTO country) {
    val updatedCountry = this.countryService.updateCountryById(id, country);

    return updatedCountry
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
