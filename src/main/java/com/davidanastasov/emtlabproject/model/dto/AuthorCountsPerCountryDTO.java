package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.views.AuthorsPerCountryView;

import java.util.List;

public record AuthorCountsPerCountryDTO(
        Long countryId,
        Integer numAuthors
) {
    public static AuthorCountsPerCountryDTO from(AuthorsPerCountryView view) {
        return new AuthorCountsPerCountryDTO(view.getCountryId(), view.getNumAuthors());
    }

    public static List<AuthorCountsPerCountryDTO> from(List<AuthorsPerCountryView> views) {
        return views.stream().map(AuthorCountsPerCountryDTO::from).toList();
    }
}
