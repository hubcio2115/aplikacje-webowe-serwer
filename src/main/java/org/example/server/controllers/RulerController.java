package org.example.server.controllers;

import lombok.RequiredArgsConstructor;
import org.example.server.domains.ruler.Ruler;
import org.example.server.domains.ruler.RulerDTO;
import org.example.server.services.CountryService;
import org.example.server.services.RulerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.val;

@CrossOrigin
@RestController
@RequestMapping("api/rulers")
@RequiredArgsConstructor
public class RulerController {
  private final RulerService rulerService;
  private final CountryService countryService;

  @GetMapping("{countryId}")
  public ResponseEntity<Ruler> getRulerByCountryId(@PathVariable long countryId) {
    val ruler = this.rulerService.getRulerByCountryId(countryId);

    return ruler.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping("{countryId}")
  public ResponseEntity<Ruler> addRuler(@PathVariable long countryId, @RequestBody RulerDTO ruler) {
    val country = this.countryService.getById(countryId);

    if (country.isEmpty()) return ResponseEntity.notFound().build();

    val newRuler = this.rulerService.addRuler(ruler, country.get());

    return newRuler.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PutMapping("{id}")
  public ResponseEntity<Ruler> updateRuler(@PathVariable long id, @RequestBody RulerDTO ruler) {
    val updatedRuler = this.rulerService.updateRulerById(id, ruler);

    return updatedRuler.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
