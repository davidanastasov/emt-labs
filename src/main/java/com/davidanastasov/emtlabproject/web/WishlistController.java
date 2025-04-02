package com.davidanastasov.emtlabproject.web;

import com.davidanastasov.emtlabproject.model.domain.User;
import com.davidanastasov.emtlabproject.model.dto.BookRentalDTO;
import com.davidanastasov.emtlabproject.model.dto.WishlistDTO;
import com.davidanastasov.emtlabproject.service.application.WishlistApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@Tag(name = "Wishlist API", description = "Endpoints for managing the wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistApplicationService wishlistApplicationService;

    @Operation(
            summary = "Get active wishlist",
            description = "Retrieves the active wishlist for the logged-in user"
    )
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "Wishlist retrieved successfully"
            ), @ApiResponse(responseCode = "404", description = "Wishlist not found")}
    )
    @GetMapping
    public ResponseEntity<WishlistDTO> getActiveWishlist(HttpServletRequest req) {
        String username = req.getRemoteUser();
        return ResponseEntity.ok(wishlistApplicationService.getActiveWishlist(username));
    }

    @Operation(
            summary = "Add book to wishlist",
            description = "Adds a book to the wishlist for the logged-in user"
    )
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200", description = "Book added to wishlist successfully"
            ), @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            ), @ApiResponse(responseCode = "404", description = "Book not found")}
    )
    @PostMapping("add-book/{bookId}")
    public ResponseEntity<WishlistDTO> addBookToWishlist(
            @PathVariable Long bookId,
            Authentication authentication
    ) {
        try {
            User user = (User) authentication.getPrincipal();
            return wishlistApplicationService.addBookToWishlist(user.getUsername(), bookId)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/rent-all")
    public ResponseEntity<List<BookRentalDTO>> rentAllBooksFromWishlist(Authentication authentication) {
        try {
            User user = (User) authentication.getPrincipal();
            return ResponseEntity.ok(wishlistApplicationService.rentAllBooksFromWishlist(user.getUsername()));
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}