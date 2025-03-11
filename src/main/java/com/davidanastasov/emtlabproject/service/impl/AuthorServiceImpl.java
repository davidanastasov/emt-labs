package com.davidanastasov.emtlabproject.service.impl;

import com.davidanastasov.emtlabproject.model.Author;
import com.davidanastasov.emtlabproject.model.Country;
import com.davidanastasov.emtlabproject.model.dto.AuthorDTO;
import com.davidanastasov.emtlabproject.repository.AuthorRepository;
import com.davidanastasov.emtlabproject.repository.CountryRepository;
import com.davidanastasov.emtlabproject.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(AuthorDTO author) {
        Optional<Country> country = author.countryId() != null
                ? countryRepository.findById(author.countryId())
                : Optional.empty();

        if (country.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(
                authorRepository.save(new Author(author.name(), author.surname(), country.get()))
        );
    }

    @Override
    public Optional<Author> update(Long id, AuthorDTO author) {
        return authorRepository.findById(id)
                .map(existingAuthor -> {
                    if (author.name() != null) {
                        existingAuthor.setName(author.name());
                    }

                    if (author.surname() != null) {
                        existingAuthor.setSurname(author.surname());
                    }

                    if (author.countryId() != null) {
                        var country = countryRepository.findById(author.countryId());
                        if (country.isEmpty()) {
                            return null;
                        }
                        existingAuthor.setCountry(country.get());
                    }

                    return authorRepository.save(existingAuthor);
                });
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
