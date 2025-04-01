package com.davidanastasov.emtlabproject.service;


import com.davidanastasov.emtlabproject.model.domain.Author;
import com.davidanastasov.emtlabproject.model.dto.CreateAuthorDTO;
import com.davidanastasov.emtlabproject.model.dto.UpdateAuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(CreateAuthorDTO author);

    Optional<Author> update(Long id, UpdateAuthorDTO author);

    void deleteById(Long id);
}
