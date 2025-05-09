package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.Book;
import com.davidanastasov.emtlabproject.model.enumerations.Category;

import java.util.List;

public record BookDTO(
        Long id,
        String name,
        Category category,
        AuthorDTO author,
        Integer availableCopies
) {

    public static BookDTO from(Book book) {
        var authorDTO = AuthorDTO.from(book.getAuthor());
        return new BookDTO(book.getId(), book.getName(), book.getCategory(), authorDTO, book.getAvailableCopies());
    }

    public static List<BookDTO> from(List<Book> countries) {
        return countries.stream().map(BookDTO::from).toList();
    }
}