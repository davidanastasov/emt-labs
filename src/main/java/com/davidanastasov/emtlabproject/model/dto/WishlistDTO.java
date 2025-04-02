package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.Wishlist;

import java.util.List;

public record WishlistDTO(
        Long id,
        UserDTO user,
        List<BookDTO> books
) {

    public static WishlistDTO from(Wishlist wishlist) {
        return new WishlistDTO(
                wishlist.getId(),
                UserDTO.from(wishlist.getUser()),
                BookDTO.from(wishlist.getBooks())
        );
    }
}