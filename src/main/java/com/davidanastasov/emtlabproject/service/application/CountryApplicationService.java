package com.davidanastasov.emtlabproject.service.application;

import com.davidanastasov.emtlabproject.model.dto.CountryDTO;
import com.davidanastasov.emtlabproject.model.dto.CreateCountryDTO;
import com.davidanastasov.emtlabproject.model.dto.UpdateCountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    List<CountryDTO> findAll();

    Optional<CountryDTO> findById(Long id);

    Optional<CountryDTO> save(CreateCountryDTO country);

    Optional<CountryDTO> update(Long id, UpdateCountryDTO country);

    void deleteById(Long id);
}
