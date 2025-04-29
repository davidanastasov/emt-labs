package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.Author;

import java.util.List;

public record AuthorDTO(
        Long id,
        String name,
        String surname,
        Long countryId
) {

    public static AuthorDTO from(Author author) {
        return new AuthorDTO(author.getId(), author.getName(), author.getSurname(), author.getCountry().getId());
    }

    public static List<AuthorDTO> from(List<Author> countries) {
        return countries.stream().map(AuthorDTO::from).toList();
    }
}