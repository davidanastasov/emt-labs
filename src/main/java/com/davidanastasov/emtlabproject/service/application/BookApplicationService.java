package com.davidanastasov.emtlabproject.service.application;

import com.davidanastasov.emtlabproject.model.dto.*;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    List<BookDTO> findAll();

    Optional<BookDTO> findById(Long id);

    Optional<BookDTO> save(CreateBookDTO book);

    Optional<BookDTO> update(Long id, UpdateBookDTO book);

    void deleteById(Long id);

    Optional<BookDTO> rent(Long id, RentBookDTO bookRental);

    List<BookRentalDTO> findRentalsByBookId(Long id);

    Optional<BookDTO> findMostRentedBook();

    Optional<AuthorDTO> findMostRentedAuthor();

    Optional<UserDTO> findUserWithMostRentals();
}
