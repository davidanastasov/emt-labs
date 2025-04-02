package com.davidanastasov.emtlabproject.service.domain.impl;

import com.davidanastasov.emtlabproject.model.domain.BookRental;
import com.davidanastasov.emtlabproject.model.domain.Wishlist;
import com.davidanastasov.emtlabproject.model.exceptions.BookAlreadyInWishlistException;
import com.davidanastasov.emtlabproject.model.exceptions.BookNotFoundException;
import com.davidanastasov.emtlabproject.model.exceptions.UserNotFoundException;
import com.davidanastasov.emtlabproject.repository.WishlistRepository;
import com.davidanastasov.emtlabproject.service.domain.BookService;
import com.davidanastasov.emtlabproject.service.domain.UserService;
import com.davidanastasov.emtlabproject.service.domain.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserService userService;
    private final BookService bookService;

    @Override
    public Wishlist getActiveWishlist(String username) {
        var user = userService.findByUsername(username).orElseThrow(UserNotFoundException::new);

        return (wishlistRepository
                .findByUser(user)
                .orElseGet(() -> wishlistRepository.save(new Wishlist(user))));
    }

    @Override
    public Optional<Wishlist> addBookToWishlist(String username, Long bookId) {
        var wishlist = getActiveWishlist(username);

        var book = bookService.findById(bookId).orElseThrow(BookNotFoundException::new);

        if (!wishlist.getBooks().stream().filter(i -> i.getId().equals(bookId)).toList().isEmpty())
            throw new BookAlreadyInWishlistException();

        wishlist.getBooks().add(book);
        return Optional.of(wishlistRepository.save(wishlist));
    }

    @Override
    public List<BookRental> rentAllBooksFromWishlist(String username) {
        var wishlist = getActiveWishlist(username);
        var user = wishlist.getUser();

        if (wishlist.getBooks().isEmpty()) {
            throw new RuntimeException("Wishlist is empty!");
        }

        var rentals = wishlist.getBooks().stream().map(book -> new BookRental(book, user)).toList();

        for (var rental : rentals) {
            bookService.rent(rental.getBook().getId(), rental);
        }

        // Empty wishlist
        wishlist.getBooks().clear();
        wishlistRepository.save(wishlist);

        return rentals;
    }
}
