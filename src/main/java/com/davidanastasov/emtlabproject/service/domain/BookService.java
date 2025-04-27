package com.davidanastasov.emtlabproject.service.domain;

import com.davidanastasov.emtlabproject.model.domain.Author;
import com.davidanastasov.emtlabproject.model.domain.Book;
import com.davidanastasov.emtlabproject.model.domain.BookRental;
import com.davidanastasov.emtlabproject.model.domain.User;
import com.davidanastasov.emtlabproject.model.views.BooksPerAuthorView;

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

    Optional<Book> findMostRentedBook();

    Optional<Author> findMostRentedAuthor();

    Optional<User> findUserWithMostRentals();

    List<BooksPerAuthorView> getBookCountsPerAuthor();

    void refreshMaterializedView();
}
