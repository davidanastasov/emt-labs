package com.davidanastasov.emtlabproject.config;

import com.davidanastasov.emtlabproject.model.Author;
import com.davidanastasov.emtlabproject.model.Continent;
import com.davidanastasov.emtlabproject.model.Country;
import com.davidanastasov.emtlabproject.repository.AuthorRepository;
import com.davidanastasov.emtlabproject.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;

    @PostConstruct
    public void init() {
        countryRepository.save(new Country("Macedonia", Continent.EUROPE));
        var uk = countryRepository.save(new Country("United Kingdom", Continent.EUROPE));
        countryRepository.save(new Country("United States of America", Continent.NORTH_AMERICA));

        authorRepository.save(new Author("William", "Shakespeare", uk));
    }
}

