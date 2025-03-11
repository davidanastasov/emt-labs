package com.davidanastasov.emtlabproject.model.dto;

public record AuthorDTO(
        String name,
        String surname,
        Long countryId
) {}