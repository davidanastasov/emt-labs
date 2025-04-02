package com.davidanastasov.emtlabproject.service.domain.impl;

import com.davidanastasov.emtlabproject.model.domain.BookRental;
import com.davidanastasov.emtlabproject.model.domain.Wishlist;
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
    public Optional<Wishlist> getActiveWishlist(String username) {
        var user = userService.findByUsername(username);

        if (user.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(wishlistRepository
                .findByUser(user.get())
                .orElseGet(() -> wishlistRepository.save(new Wishlist(user.get()))));
    }

    @Override
    public Optional<Wishlist> addBookToWishlist(String username, Long bookId) {
        var activeWishlist = getActiveWishlist(username);

        if (activeWishlist.isPresent()) {
            Wishlist wishlist = activeWishlist.get();

            var book = bookService.findById(bookId);

            if (book.isEmpty()) {
                return Optional.empty();
            }

            if (!wishlist.getBooks().stream().filter(i -> i.getId().equals(bookId)).toList().isEmpty())
                return Optional.empty(); // Already exists

            wishlist.getBooks().add(book.get());
            return Optional.of(wishlistRepository.save(wishlist));
        }
        return Optional.empty();
    }

    @Override
    public List<BookRental> rentAllBooksFromWishlist(String username) {
        var user = userService.findByUsername(username);
        var wishlist = getActiveWishlist(username);

        if (wishlist.isEmpty() || user.isEmpty()) {
            return List.of();
        }

        if (wishlist.get().getBooks().isEmpty()) {
            throw new RuntimeException("Wishlist is empty!");
        }

        var rentals = wishlist.get().getBooks().stream().map(book -> new BookRental(book, user.get())).toList();

        for (var rental : rentals) {
            bookService.rent(rental.getBook().getId(), rental);
        }

        // Empty wishlist
        wishlist.get().getBooks().clear();
        wishlistRepository.save(wishlist.get());

        return rentals;
    }
}
