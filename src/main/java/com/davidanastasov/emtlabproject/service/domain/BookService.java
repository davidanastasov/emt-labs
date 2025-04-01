package com.davidanastasov.emtlabproject.service.domain;

import com.davidanastasov.emtlabproject.model.domain.Book;
import com.davidanastasov.emtlabproject.model.domain.BookRental;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(Book book);

    Optional<Book> update(Long id, Book book);

    void deleteById(Long id);

    Optional<Book> rent(Long id, BookRental bookRental);

    List<BookRental> findRentalsByBookId(Long id);
}
