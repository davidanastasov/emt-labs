package com.davidanastasov.emtlabproject.service.application;

import com.davidanastasov.emtlabproject.model.dto.BookDTO;
import com.davidanastasov.emtlabproject.model.dto.BookRentalDTO;
import com.davidanastasov.emtlabproject.model.dto.CreateBookDTO;
import com.davidanastasov.emtlabproject.model.dto.UpdateBookDTO;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    List<BookDTO> findAll();

    Optional<BookDTO> findById(Long id);

    Optional<BookDTO> save(CreateBookDTO book);

    Optional<BookDTO> update(Long id, UpdateBookDTO book);

    void deleteById(Long id);

    Optional<BookDTO> rent(Long id, BookRentalDTO bookRental);

    List<BookRentalDTO> findRentalsByBookId(Long id);
}
