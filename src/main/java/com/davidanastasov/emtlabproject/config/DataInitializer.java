package com.davidanastasov.emtlabproject.config;

import com.davidanastasov.emtlabproject.model.domain.Author;
import com.davidanastasov.emtlabproject.model.domain.Book;
import com.davidanastasov.emtlabproject.model.domain.Country;
import com.davidanastasov.emtlabproject.model.enumerations.Category;
import com.davidanastasov.emtlabproject.model.enumerations.Continent;
import com.davidanastasov.emtlabproject.repository.AuthorRepository;
import com.davidanastasov.emtlabproject.repository.BookRepository;
import com.davidanastasov.emtlabproject.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @PostConstruct
    public void init() {
        // Countries
        countryRepository.save(new Country("Macedonia", Continent.EUROPE));
        var uk = countryRepository.save(new Country("United Kingdom", Continent.EUROPE));
        countryRepository.save(new Country("United States of America", Continent.NORTH_AMERICA));

        // Authors
        var shakespeare = authorRepository.save(new Author("William", "Shakespeare", uk));

        // Books
        bookRepository.save(new Book("Romeo and Juliet", Category.CLASSICS, shakespeare, 10));
    }
}

