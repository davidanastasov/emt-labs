package com.davidanastasov.emtlabproject.service.application.impl;

import com.davidanastasov.emtlabproject.model.dto.*;
import com.davidanastasov.emtlabproject.model.exceptions.AuthorNotFoundException;
import com.davidanastasov.emtlabproject.model.exceptions.BookNotFoundException;
import com.davidanastasov.emtlabproject.model.exceptions.UserNotFoundException;
import com.davidanastasov.emtlabproject.service.application.BookApplicationService;
import com.davidanastasov.emtlabproject.service.domain.AuthorService;
import com.davidanastasov.emtlabproject.service.domain.BookService;
import com.davidanastasov.emtlabproject.service.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookApplicationServiceImpl implements BookApplicationService {

    private final BookService bookService;
    private final AuthorService authorService;
    private final UserService userService;

    @Override
    public List<BookDTO> findAll() {
        return BookDTO.from(bookService.findAll());
    }

    @Override
    public Optional<BookDTO> findById(Long id) {
        return bookService.findById(id).map(BookDTO::from);
    }

    @Override
    public Optional<BookDTO> save(CreateBookDTO book) {
        var author = authorService
                .findById(book.authorId())
                .orElseThrow(() -> new AuthorNotFoundException(book.authorId()));

        return bookService.save(book.toBook(author)).map(BookDTO::from);
    }

    @Override
    public Optional<BookDTO> update(Long id, UpdateBookDTO book) {
        var author = authorService
                .findById(book.authorId())
                .orElseThrow(() -> new AuthorNotFoundException(book.authorId()));

        return bookService.update(id, book.toBook(author)).map(BookDTO::from);
    }

    @Override
    public void deleteById(Long id) {
        bookService.deleteById(id);
    }

    @Override
    public Optional<BookDTO> rent(Long id, RentBookDTO bookRental) {
        var book = bookService
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        var user = userService
                .findByUsername(bookRental.username())
                .orElseThrow(() -> new UserNotFoundException(bookRental.username()));

        return bookService
                .rent(id, bookRental.toBookRental(book, user))
                .map(BookDTO::from);
    }

    @Override
    public List<BookRentalDTO> findRentalsByBookId(Long id) {
        return BookRentalDTO.from(bookService.findRentalsByBookId(id));
    }

    @Override
    public Optional<BookDTO> findMostRentedBook() {
        return bookService.findMostRentedBook().map(BookDTO::from);
    }

    @Override
    public Optional<AuthorDTO> findMostRentedAuthor() {
        return bookService.findMostRentedAuthor().map(AuthorDTO::from);
    }

    @Override
    public Optional<UserDTO> findUserWithMostRentals() {
        return bookService.findUserWithMostRentals().map(UserDTO::from);
    }
}
