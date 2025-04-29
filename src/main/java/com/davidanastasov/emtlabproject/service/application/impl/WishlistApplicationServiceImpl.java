package com.davidanastasov.emtlabproject.service.application.impl;

import com.davidanastasov.emtlabproject.model.dto.BookRentalDTO;
import com.davidanastasov.emtlabproject.model.dto.WishlistDTO;
import com.davidanastasov.emtlabproject.service.application.WishlistApplicationService;
import com.davidanastasov.emtlabproject.service.domain.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishlistApplicationServiceImpl implements WishlistApplicationService {

    private final WishlistService wishlistService;

    @Override
    public WishlistDTO getActiveWishlist(String username) {
        return WishlistDTO.from(wishlistService.getActiveWishlist(username));
    }

    @Override
    public Optional<WishlistDTO> addBookToWishlist(String username, Long bookId) {
        return wishlistService.addBookToWishlist(username, bookId).map(WishlistDTO::from);
    }

    @Override
    public Optional<WishlistDTO> removeBookFromWishlist(String username, Long bookId) {
        return wishlistService.removeBookFromWishlist(username, bookId).map(WishlistDTO::from);
    }

    @Override
    public List<BookRentalDTO> rentAllBooksFromWishlist(String username) {
        return BookRentalDTO.from(wishlistService.rentAllBooksFromWishlist(username));
    }

    @Override
    public void clearWishlist(String username) {
        wishlistService.clearWishlist(username);
    }
}
