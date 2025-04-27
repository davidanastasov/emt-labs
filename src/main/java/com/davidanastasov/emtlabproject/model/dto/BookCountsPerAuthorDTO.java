package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.views.BooksPerAuthorView;

import java.util.List;

public record BookCountsPerAuthorDTO(Long authorId, Integer numBooks) {
    public static BookCountsPerAuthorDTO from(BooksPerAuthorView view) {
        return new BookCountsPerAuthorDTO(view.getAuthorId(), view.getNumBooks());
    }

    public static List<BookCountsPerAuthorDTO> from(List<BooksPerAuthorView> views) {
        return views.stream().map(BookCountsPerAuthorDTO::from).toList();
    }
}
