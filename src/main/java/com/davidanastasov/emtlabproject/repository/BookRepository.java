package com.davidanastasov.emtlabproject.repository;

import com.davidanastasov.emtlabproject.model.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthorCountryId(Long id);
}
