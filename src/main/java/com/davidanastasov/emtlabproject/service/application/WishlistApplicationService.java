package com.davidanastasov.emtlabproject.service.application;

import com.davidanastasov.emtlabproject.model.dto.BookRentalDTO;
import com.davidanastasov.emtlabproject.model.dto.WishlistDTO;

import java.util.List;
import java.util.Optional;

public interface WishlistApplicationService {

    WishlistDTO getActiveWishlist(String username);

    Optional<WishlistDTO> addBookToWishlist(String username, Long bookId);

    List<BookRentalDTO> rentAllBooksFromWishlist(String username);
}
