package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.Author;

import java.util.List;

public record AuthorDTO(
        Long id,
        String name,
        String surname,
        CountryDTO country
) {

    public static AuthorDTO from(Author author) {
        var countryDTO = CountryDTO.from(author.getCountry());
        return new AuthorDTO(author.getId(), author.getName(), author.getSurname(), countryDTO);
    }

    public static List<AuthorDTO> from(List<Author> countries) {
        return countries.stream().map(AuthorDTO::from).toList();
    }
}