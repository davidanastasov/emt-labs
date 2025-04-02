package com.davidanastasov.emtlabproject.repository;

import com.davidanastasov.emtlabproject.model.domain.Author;
import com.davidanastasov.emtlabproject.model.domain.Book;
import com.davidanastasov.emtlabproject.model.domain.BookRental;
import com.davidanastasov.emtlabproject.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRentalRepository extends JpaRepository<BookRental, Long> {
    List<BookRental> findByBookId(Long id);

    @Query("SELECT br.book FROM BookRental br GROUP BY br.book ORDER BY COUNT(br.id) DESC LIMIT 1")
    List<Book> findMostRentedBook();

    @Query("SELECT br.book.author FROM BookRental br GROUP BY br.book.author ORDER BY COUNT(br.id) DESC LIMIT 1")
    List<Author> findMostRentedAuthor();

    @Query("SELECT br.user FROM BookRental br GROUP BY br.user ORDER BY COUNT(br.id) DESC LIMIT 1")
    List<User> findUserWithMostRentals();
}
