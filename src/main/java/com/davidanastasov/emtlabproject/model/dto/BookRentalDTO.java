package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.Book;
import com.davidanastasov.emtlabproject.model.domain.BookRental;
import com.davidanastasov.emtlabproject.model.domain.User;

import java.util.List;

public record BookRentalDTO(
        Long id,
        String username,
        BookDTO book
) {

    public BookRental toBookRental(Book book, User user) {
        return new BookRental(book, user);
    }

    public static BookRentalDTO from(BookRental bookRental) {
        return new BookRentalDTO(
                bookRental.getId(),
                bookRental.getUser().getUsername(),
                BookDTO.from(bookRental.getBook())
        );
    }

    public static List<BookRentalDTO> from(List<BookRental> bookRentals) {
        return bookRentals.stream().map(BookRentalDTO::from).toList();
    }
}
