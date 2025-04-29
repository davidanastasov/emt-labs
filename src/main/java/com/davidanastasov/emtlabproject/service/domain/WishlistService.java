package com.davidanastasov.emtlabproject.service.domain;

import com.davidanastasov.emtlabproject.model.domain.BookRental;
import com.davidanastasov.emtlabproject.model.domain.Wishlist;

import java.util.List;
import java.util.Optional;

public interface WishlistService {

    Wishlist getActiveWishlist(String username);

    Optional<Wishlist> addBookToWishlist(String username, Long bookId);

    Optional<Wishlist> removeBookFromWishlist(String username, Long bookId);

    List<BookRental> rentAllBooksFromWishlist(String username);

    void clearWishlist(String username);
}

