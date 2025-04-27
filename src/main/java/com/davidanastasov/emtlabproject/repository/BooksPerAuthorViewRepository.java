package com.davidanastasov.emtlabproject.repository;

import com.davidanastasov.emtlabproject.model.views.BooksPerAuthorView;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksPerAuthorViewRepository extends JpaRepository<BooksPerAuthorView, Long> {
    List<BooksPerAuthorView> findByAuthorId(Long authorId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.books_per_author", nativeQuery = true)
    void refreshMaterializedView();
}
