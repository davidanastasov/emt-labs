package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.Book;
import com.davidanastasov.emtlabproject.model.domain.BookRental;
import com.davidanastasov.emtlabproject.model.domain.User;

import java.util.List;

public record RentBookDTO(
        String username
) {

    public BookRental toBookRental(Book book, User user) {
        return new BookRental(book, user);
    }

    public static RentBookDTO from(BookRental bookRental) {
        return new RentBookDTO(bookRental.getUser().getUsername());
    }

    public static List<RentBookDTO> from(List<BookRental> bookRentals) {
        return bookRentals.stream().map(RentBookDTO::from).toList();
    }
}
