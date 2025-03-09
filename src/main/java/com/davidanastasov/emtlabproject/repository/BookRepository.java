package com.davidanastasov.emtlabproject.repository;

import com.davidanastasov.emtlabproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
