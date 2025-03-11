package com.davidanastasov.emtlabproject.service.impl;

import com.davidanastasov.emtlabproject.model.Author;
import com.davidanastasov.emtlabproject.model.Book;
import com.davidanastasov.emtlabproject.model.dto.BookDTO;
import com.davidanastasov.emtlabproject.repository.AuthorRepository;
import com.davidanastasov.emtlabproject.repository.BookRepository;
import com.davidanastasov.emtlabproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDTO book) {
        Optional<Author> author = book.authorId() != null
                ? authorRepository.findById(book.authorId())
                : Optional.empty();

        if (author.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(
                bookRepository.save(new Book(book.name(), book.category(), author.get(), book.availableCopies()))
        );
    }

    @Override
    public Optional<Book> update(Long id, BookDTO book) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    if (book.name() != null) {
                        existingBook.setName(book.name());
                    }

                    if (book.category() != null) {
                        existingBook.setCategory(book.category());
                    }

                    if (book.availableCopies() != null) {
                        existingBook.setAvailableCopies(book.availableCopies());
                    }

                    if (book.authorId() != null) {
                        var author = authorRepository.findById(book.authorId());
                        if (author.isEmpty()) {
                            return null;
                        }
                        existingBook.setAuthor(author.get());
                    }

                    return bookRepository.save(existingBook);
                });
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> rent(Long id) {
        return bookRepository.findById(id)
                .filter(book -> book.getAvailableCopies() > 0)
                .map(book -> {
                    book.setAvailableCopies(book.getAvailableCopies() - 1);
                    return bookRepository.save(book);
                });
    }
}
