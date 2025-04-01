package com.davidanastasov.emtlabproject.web;

import com.davidanastasov.emtlabproject.model.dto.BookDTO;
import com.davidanastasov.emtlabproject.model.dto.BookRentalDTO;
import com.davidanastasov.emtlabproject.model.dto.CreateBookDTO;
import com.davidanastasov.emtlabproject.model.dto.UpdateBookDTO;
import com.davidanastasov.emtlabproject.service.application.BookApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BookDTO> rentBook(@PathVariable Long id, @RequestBody BookRentalDTO bookRental) {
        return bookApplicationService.rent(id, bookRental)
                .map(rentedBook -> ResponseEntity.ok().body(rentedBook))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get all book rentals by ID", description = "This endpoint returns all the rentals for a given book.")
    @GetMapping("{id}/rentals")
    public List<BookRentalDTO> findAllRentalsById(@PathVariable Long id) {
        return bookApplicationService.findRentalsByBookId(id);
    }
}
