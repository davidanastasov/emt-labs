package com.davidanastasov.emtlabproject.service;

import com.davidanastasov.emtlabproject.model.domain.Country;
import com.davidanastasov.emtlabproject.model.dto.CreateCountryDTO;
import com.davidanastasov.emtlabproject.model.dto.UpdateCountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(CreateCountryDTO country);

    Optional<Country> update(Long id, UpdateCountryDTO country);

    void deleteById(Long id);
}
