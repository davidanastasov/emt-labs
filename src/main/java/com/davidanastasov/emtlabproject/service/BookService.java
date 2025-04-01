package com.davidanastasov.emtlabproject.service;

import com.davidanastasov.emtlabproject.model.domain.Book;
import com.davidanastasov.emtlabproject.model.dto.BookDTO;
import com.davidanastasov.emtlabproject.model.dto.BookRentalDTO;
import com.davidanastasov.emtlabproject.model.dto.CreateBookDTO;
import com.davidanastasov.emtlabproject.model.dto.UpdateBookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(CreateBookDTO book);

    Optional<Book> update(Long id, UpdateBookDTO book);

    void deleteById(Long id);

    Optional<Book> rent(Long id, BookRentalDTO bookRental);

    List<BookRentalDTO> findRentalsByBookId(Long id);
}
