package com.davidanastasov.emtlabproject.service.application;

import com.davidanastasov.emtlabproject.model.dto.AuthorCountsPerCountryDTO;
import com.davidanastasov.emtlabproject.model.dto.AuthorDTO;
import com.davidanastasov.emtlabproject.model.dto.CreateAuthorDTO;
import com.davidanastasov.emtlabproject.model.dto.UpdateAuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {
    List<AuthorDTO> findAll();

    Optional<AuthorDTO> findById(Long id);

    Optional<AuthorDTO> save(CreateAuthorDTO author);

    Optional<AuthorDTO> update(Long id, UpdateAuthorDTO author);

    void deleteById(Long id);

    List<AuthorCountsPerCountryDTO> getAuthorCountsPerCountry();
}
