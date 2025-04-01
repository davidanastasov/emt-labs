package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.Author;
import com.davidanastasov.emtlabproject.model.domain.Book;
import com.davidanastasov.emtlabproject.model.enumerations.Category;

public record CreateBookDTO(
        String name,
        Category category,
        Long authorId,
        Integer availableCopies
) {

    public Book toBook(Author author) {
        return new Book(name, category, author, availableCopies);
    }
}
