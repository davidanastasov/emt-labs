package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.Book;
import com.davidanastasov.emtlabproject.model.enumerations.Category;

import java.util.List;

public record BookDTO(
        String name,
        Category category,
        Long authorId,
        Integer availableCopies
) {

    public static BookDTO from(Book country) {
        return new BookDTO(country.getName(), country.getCategory(), country.getAuthor().getId(), country.getAvailableCopies());
    }

    public static List<BookDTO> from(List<Book> countries) {
        return countries.stream().map(BookDTO::from).toList();
    }
}