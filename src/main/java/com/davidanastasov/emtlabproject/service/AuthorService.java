package com.davidanastasov.emtlabproject.service;


import com.davidanastasov.emtlabproject.model.Author;
import com.davidanastasov.emtlabproject.model.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(AuthorDTO author);

    Optional<Author> update(Long id, AuthorDTO author);

    void deleteById(Long id);
}
