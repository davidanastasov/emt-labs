package com.davidanastasov.emtlabproject.service.application;

import com.davidanastasov.emtlabproject.model.dto.*;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {
    List<AuthorDTO> findAll();

    Optional<AuthorDTO> findById(Long id);

    Optional<AuthorDTO> save(CreateAuthorDTO author);

    Optional<AuthorDTO> update(Long id, UpdateAuthorDTO author);

    void deleteById(Long id);

    List<AuthorCountsPerCountryDTO> getAuthorCountsPerCountry();

    List<AuthorNameDTO> getAuthorNames();
}
