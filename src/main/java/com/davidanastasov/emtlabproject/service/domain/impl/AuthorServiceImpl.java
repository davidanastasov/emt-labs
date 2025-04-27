package com.davidanastasov.emtlabproject.service.domain.impl;

import com.davidanastasov.emtlabproject.events.AuthorCreatedEvent;
import com.davidanastasov.emtlabproject.events.AuthorDeletedEvent;
import com.davidanastasov.emtlabproject.events.AuthorEditedEvent;
import com.davidanastasov.emtlabproject.model.domain.Author;
import com.davidanastasov.emtlabproject.model.views.AuthorsPerCountryView;
import com.davidanastasov.emtlabproject.repository.AuthorRepository;
import com.davidanastasov.emtlabproject.repository.AuthorsPerCountryViewRepository;
import com.davidanastasov.emtlabproject.service.domain.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorsPerCountryViewRepository authorsPerCountryViewRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(Author author) {
        var newAuthor = authorRepository.save(author);

        applicationEventPublisher.publishEvent(new AuthorCreatedEvent(newAuthor));

        return Optional.of(newAuthor);
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return authorRepository.findById(id)
                .map(existingAuthor -> {
                    if (author.getName() != null) {
                        existingAuthor.setName(author.getName());
                    }

                    if (author.getSurname() != null) {
                        existingAuthor.setSurname(author.getSurname());
                    }

                    if (author.getCountry() != null) {
                        existingAuthor.setCountry(author.getCountry());
                    }

                    var updatedAuthor = authorRepository.save(existingAuthor);

                    applicationEventPublisher.publishEvent(new AuthorEditedEvent(updatedAuthor));

                    return updatedAuthor;
                });
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
        applicationEventPublisher.publishEvent(new AuthorDeletedEvent(null));
    }

    @Override
    public List<AuthorsPerCountryView> getAuthorCountsPerCountry() {
        return authorsPerCountryViewRepository.findAll();
    }

    @Override
    public void refreshMaterializedView() {
        authorsPerCountryViewRepository.refreshMaterializedView();
    }
}
