package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.Book;
import com.davidanastasov.emtlabproject.model.domain.BookRental;

import java.util.List;

public record BookRentalDTO(
        String username
) {

    public BookRental toBookRental(Book book) {
        return new BookRental(book, username);
    }

    public static BookRentalDTO from(BookRental bookRental) {
        return new BookRentalDTO(bookRental.getUsername());
    }

    public static List<BookRentalDTO> from(List<BookRental> bookRentals) {
        return bookRentals.stream().map(BookRentalDTO::from).toList();
    }
}
