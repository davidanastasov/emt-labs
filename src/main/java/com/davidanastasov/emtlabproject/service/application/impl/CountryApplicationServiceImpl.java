package com.davidanastasov.emtlabproject.service.application.impl;

import com.davidanastasov.emtlabproject.model.dto.CountryDTO;
import com.davidanastasov.emtlabproject.model.dto.CreateCountryDTO;
import com.davidanastasov.emtlabproject.model.dto.UpdateCountryDTO;
import com.davidanastasov.emtlabproject.service.application.CountryApplicationService;
import com.davidanastasov.emtlabproject.service.domain.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryService countryService;

    @Override
    public List<CountryDTO> findAll() {
        return CountryDTO.from(countryService.findAll());
    }

    @Override
    public Optional<CountryDTO> findById(Long id) {
        return countryService.findById(id).map(CountryDTO::from);
    }

    @Override
    public Optional<CountryDTO> save(CreateCountryDTO country) {
        return countryService.save(country.toCategory()).map(CountryDTO::from);
    }

    @Override
    public Optional<CountryDTO> update(Long id, UpdateCountryDTO country) {
        return countryService.update(id, country.toCategory()).map(CountryDTO::from);
    }

    @Override
    public void deleteById(Long id) {
        countryService.deleteById(id);
    }
}
