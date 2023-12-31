package org.example.springguide.services;

import org.example.springguide.domains.Country;
import org.example.springguide.domains.Ruler;
import org.example.springguide.domains.RulerDTO;
import org.example.springguide.domains.RulerRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
        var newRuler = new Ruler(
                ruler.name(), ruler.surname(), ruler.officeStartDate()
        );
        newRuler.setCountry(country);

        return Optional.of(
                this.rulerRepository.save(newRuler)
        );
    }

    public Optional<Ruler> deleteById(long id) {
        var ruler = this.getById(id);

        if (ruler.isEmpty()) return Optional.empty();

        this.rulerRepository.deleteById(id);
        return ruler;
    }

    public Optional<Ruler> getRulerByCountryId(long countryId) {
        return this.rulerRepository.findByCountryId(countryId);
    }


    public Optional<Ruler> updateRulerById(long rulerId, RulerDTO ruler) {
        var rulerFromDb = this.rulerRepository.findById(rulerId);
        if (rulerFromDb.isEmpty()) return Optional.empty();

        var updatedRuler = rulerFromDb.get();

        updatedRuler.setName(ruler.name());
        updatedRuler.setSurname(ruler.surname());
        updatedRuler.setOfficeStartDate(ruler.officeStartDate());

        return Optional.of(
                this.rulerRepository.save(updatedRuler)
        );
    }
}
