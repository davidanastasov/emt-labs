package com.davidanastasov.emtlabproject.service.application.impl;

import com.davidanastasov.emtlabproject.model.dto.BookDTO;
import com.davidanastasov.emtlabproject.model.dto.BookRentalDTO;
import com.davidanastasov.emtlabproject.model.dto.CreateBookDTO;
import com.davidanastasov.emtlabproject.model.dto.UpdateBookDTO;
import com.davidanastasov.emtlabproject.service.application.BookApplicationService;
import com.davidanastasov.emtlabproject.service.domain.AuthorService;
import com.davidanastasov.emtlabproject.service.domain.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookApplicationServiceImpl implements BookApplicationService {

    private final BookService bookService;
    private final AuthorService authorService;

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
        var author = authorService.findById(book.authorId());
        if (author.isEmpty()) {
            return Optional.empty();
        }

        return bookService.save(book.toBook(author.get())).map(BookDTO::from);
    }

    @Override
    public Optional<BookDTO> update(Long id, UpdateBookDTO book) {
        var author = authorService.findById(book.authorId());
        if (author.isEmpty()) {
            return Optional.empty();
        }

        return bookService.update(id, book.toBook(author.get())).map(BookDTO::from);
    }

    @Override
    public void deleteById(Long id) {
        bookService.deleteById(id);
    }

    @Override
    public Optional<BookDTO> rent(Long id, BookRentalDTO bookRental) {
        var book = bookService.findById(id);
        if (book.isEmpty()) {
            return Optional.empty();
        }

        return bookService.rent(id, bookRental.toBookRental(book.get())).map(BookDTO::from);
    }

    @Override
    public List<BookRentalDTO> findRentalsByBookId(Long id) {
        return BookRentalDTO.from(bookService.findRentalsByBookId(id));
    }
}
