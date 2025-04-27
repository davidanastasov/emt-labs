package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.projections.AuthorNameProjection;

import java.util.List;

public record AuthorNameDTO(
        String name,
        String surname
) {
    public static AuthorNameDTO from(AuthorNameProjection authorName) {
        return new AuthorNameDTO(authorName.getName(), authorName.getSurname());
    }

    public static List<AuthorNameDTO> from(List<AuthorNameProjection> authorNames) {
        return authorNames.stream().map(AuthorNameDTO::from).toList();
    }
}
