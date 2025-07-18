package com.davidanastasov.emtlabproject.service.domain.impl;

import com.davidanastasov.emtlabproject.model.domain.Author;
import com.davidanastasov.emtlabproject.model.domain.Book;
import com.davidanastasov.emtlabproject.model.domain.BookRental;
import com.davidanastasov.emtlabproject.model.domain.User;
import com.davidanastasov.emtlabproject.model.views.BooksPerAuthorView;
import com.davidanastasov.emtlabproject.repository.BookRentalRepository;
import com.davidanastasov.emtlabproject.repository.BookRepository;
import com.davidanastasov.emtlabproject.repository.BooksPerAuthorViewRepository;
import com.davidanastasov.emtlabproject.service.domain.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookRentalRepository bookRentalRepository;
    private final BooksPerAuthorViewRepository booksPerAuthorViewRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBooksByCountryId(Long id) {
        return bookRepository.findAllByAuthorCountryId(id);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(Book book) {
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    if (book.getName() != null) {
                        existingBook.setName(book.getName());
                    }

                    if (book.getCategory() != null) {
                        existingBook.setCategory(book.getCategory());
                    }

                    if (book.getAvailableCopies() != null) {
                        existingBook.setAvailableCopies(book.getAvailableCopies());
                    }

                    if (book.getAuthor() != null) {
                        existingBook.setAuthor(book.getAuthor());
                    }

                    return bookRepository.save(existingBook);
                });
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> rent(Long id, BookRental bookRental) {
        return bookRepository.findById(id)
                .filter(book -> book.getAvailableCopies() > 0)
                .map(book -> {
                    book.setAvailableCopies(book.getAvailableCopies() - 1);
                    bookRentalRepository.save(bookRental);
                    return bookRepository.save(book);
                });
    }

    @Override
    public List<BookRental> findRentalsByBookId(Long id) {
        return bookRentalRepository.findByBookId(id);
    }

    @Override
    public Optional<Book> findMostRentedBook() {
        return bookRentalRepository.findMostRentedBook().stream().findFirst();
    }

    @Override
    public Optional<Author> findMostRentedAuthor() {
        return bookRentalRepository.findMostRentedAuthor().stream().findFirst();
    }

    @Override
    public Optional<User> findUserWithMostRentals() {
        return bookRentalRepository.findUserWithMostRentals().stream().findFirst();
    }

    @Override
    public List<BooksPerAuthorView> getBookCountsPerAuthor() {
        return booksPerAuthorViewRepository.findAll();
    }

    @Override
    public void refreshMaterializedView() {
        booksPerAuthorViewRepository.refreshMaterializedView();
    }
}
