package com.davidanastasov.emtlabproject.service;

import com.davidanastasov.emtlabproject.model.Country;
import com.davidanastasov.emtlabproject.model.dto.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(CountryDTO country);

    Optional<Country> update(Long id, CountryDTO country);

    void deleteById(Long id);
}
