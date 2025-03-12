package com.davidanastasov.emtlabproject.repository;

import com.davidanastasov.emtlabproject.model.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRentalRepository extends JpaRepository<BookRental, Long> {
    List<BookRental> findByBookId(Long id);
}
