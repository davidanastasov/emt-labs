package com.davidanastasov.emtlabproject.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class BookRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    public BookRental(Book book, User user) {
        this.book = book;
        this.user = user;
    }
}
