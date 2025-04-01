package com.davidanastasov.emtlabproject.repository;

import com.davidanastasov.emtlabproject.model.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
