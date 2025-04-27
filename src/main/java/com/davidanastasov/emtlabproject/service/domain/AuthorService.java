package com.davidanastasov.emtlabproject.service.domain;

import com.davidanastasov.emtlabproject.model.domain.Author;
import com.davidanastasov.emtlabproject.model.views.AuthorsPerCountryView;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(Author author);

    Optional<Author> update(Long id, Author author);

    void deleteById(Long id);

    List<AuthorsPerCountryView> getAuthorCountsPerCountry();

    void refreshMaterializedView();
}
