package com.davidanastasov.emtlabproject.service.application.impl;

import com.davidanastasov.emtlabproject.model.dto.AuthorDTO;
import com.davidanastasov.emtlabproject.model.dto.CreateAuthorDTO;
import com.davidanastasov.emtlabproject.model.dto.UpdateAuthorDTO;
import com.davidanastasov.emtlabproject.model.exceptions.CountryNotFoundException;
import com.davidanastasov.emtlabproject.service.application.AuthorApplicationService;
import com.davidanastasov.emtlabproject.service.domain.AuthorService;
import com.davidanastasov.emtlabproject.service.domain.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorApplicationServiceImpl implements AuthorApplicationService {
    private final AuthorService authorService;
    private final CountryService countryRepository;

    @Override
    public List<AuthorDTO> findAll() {
        return AuthorDTO.from(authorService.findAll());
    }

    @Override
    public Optional<AuthorDTO> findById(Long id) {
        return authorService.findById(id).map(AuthorDTO::from);
    }

    @Override
    public Optional<AuthorDTO> save(CreateAuthorDTO author) {
        var country = countryRepository
                .findById(author.countryId())
                .orElseThrow(CountryNotFoundException::new);

        return authorService.save(author.toAuthor(country)).map(AuthorDTO::from);
    }

    @Override
    public Optional<AuthorDTO> update(Long id, UpdateAuthorDTO author) {
        var country = countryRepository
                .findById(author.countryId())
                .orElseThrow(CountryNotFoundException::new);

        return authorService.update(id, author.toAuthor(country)).map(AuthorDTO::from);
    }

    @Override
    public void deleteById(Long id) {
        authorService.deleteById(id);
    }
}
