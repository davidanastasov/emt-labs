package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.Author;
import com.davidanastasov.emtlabproject.model.domain.Country;

public record CreateAuthorDTO(
        String name,
        String surname,
        Long countryId
) {

    public Author toAuthor(Country country) {
        return new Author(name, surname, country);
    }
}
