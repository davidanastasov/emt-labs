package com.davidanastasov.emtlabproject.service.impl;

import com.davidanastasov.emtlabproject.model.Country;
import com.davidanastasov.emtlabproject.model.dto.CountryDTO;
import com.davidanastasov.emtlabproject.repository.CountryRepository;
import com.davidanastasov.emtlabproject.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(CountryDTO country) {
        return Optional.of(countryRepository.save(
                new Country(country.name(), country.continent())
        ));
    }

    @Override
    public Optional<Country> update(Long id, CountryDTO country) {
        return countryRepository.findById(id)
                .map(existingCountry -> {
                    if (country.name() != null) {
                        existingCountry.setName(country.name());
                    }

                    if (country.continent() != null) {
                        existingCountry.setContinent(country.continent());
                    }

                    return countryRepository.save(existingCountry);
                });
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
