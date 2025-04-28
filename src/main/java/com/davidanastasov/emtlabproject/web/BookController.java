package com.davidanastasov.emtlabproject.web;

import com.davidanastasov.emtlabproject.model.domain.User;
import com.davidanastasov.emtlabproject.model.dto.*;
import com.davidanastasov.emtlabproject.service.application.BookApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/books")
@Tag(name = "Book Management", description = "API for managing books") // Swagger Tag
public class BookController {
    private final BookApplicationService bookApplicationService;

    @Operation(summary = "Get all books", description = "Returns a list of all books")
    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookApplicationService.findAll();
    }

    @Operation(summary = "Get a book by ID", description = "Fetches a book by its unique ID")
    @GetMapping("{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        return bookApplicationService.findById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Get book counts per author",
            description = "Retrieves a list of authors along with the number of books they have authored."
    )
    @GetMapping("by-author")
    public List<BookCountsPerAuthorDTO> getBookCountsPerAuthor() {
        return bookApplicationService.getBookCountsPerAuthor();
    }

    @Operation(summary = "Create a new book", description = "Saves a new book to the database")
    @PostMapping
    public ResponseEntity<BookDTO> save(@RequestBody CreateBookDTO book) {
        return bookApplicationService.save(book)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Update an existing book", description = "Updates a book's details")
    @PatchMapping("{id}")
    public ResponseEntity<BookDTO> update(@PathVariable Long id, @RequestBody UpdateBookDTO book) {
        return bookApplicationService.update(id, book)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a book by ID", description = "Removes a book from the database")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        if (bookApplicationService.findById(id).isPresent()) {
            bookApplicationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Rent a book by its ID", description = "This endpoint allows renting a book if it is available.")
    @PostMapping("{id}/rent")
    public ResponseEntity<BookDTO> rentBook(@PathVariable Long id, Authentication authentication) {
        try {
            User user = (User) authentication.getPrincipal();
            return bookApplicationService.rent(id, user.getUsername())
                    .map(rentedBook -> ResponseEntity.ok().body(rentedBook))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Get all book rentals by ID", description = "This endpoint returns all the rentals for a given book.")
    @GetMapping("{id}/rentals")
    public List<BookRentalDTO> findAllRentalsById(@PathVariable Long id) {
        return bookApplicationService.findRentalsByBookId(id);
    }

    @GetMapping("most-rented-book")
    public ResponseEntity<BookDTO> getBookWithMostRentals() {
        return bookApplicationService.findMostRentedBook()
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("most-rented-author")
    public ResponseEntity<AuthorDTO> getAuthorWithMostRentals() {
        return bookApplicationService.findMostRentedAuthor()
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("most-rentals-user")
    public ResponseEntity<UserDTO> getUserWithMostRentals() {
        return bookApplicationService.findUserWithMostRentals()
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }
}
