package org.example.springguide.controllers;

import org.example.springguide.domains.Ruler;
import org.example.springguide.domains.RulerDTO;
import org.example.springguide.services.CountryService;
import org.example.springguide.services.RulerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/rulers")
public class RulerController {
    private final RulerService rulerService;
    private final CountryService countryService;

    public RulerController(RulerService rulerService, CountryService countryService) {
        this.rulerService = rulerService;
        this.countryService = countryService;
    }

    @GetMapping("{countryId}")
    public ResponseEntity<Ruler> getRulerByCountryId(@PathVariable long countryId) {
        var ruler = this.rulerService.getRulerByCountryId(countryId);

        return ruler
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("{countryId}")
    public ResponseEntity<Ruler> addRuler(@PathVariable long countryId, @RequestBody RulerDTO ruler) {
        var country = this.countryService.getById(countryId);

        if (country.isEmpty()) return ResponseEntity.notFound().build();

        var newRuler = this.rulerService.addRuler(ruler, country.get());

        return newRuler
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Ruler> updateRuler(@PathVariable long id, @RequestBody RulerDTO ruler) {
        var updatedRuler = this.rulerService.updateRulerById(id, ruler);

        return updatedRuler
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
