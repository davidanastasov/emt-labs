package com.davidanastasov.emtlabproject.web;

import com.davidanastasov.emtlabproject.model.Author;
import com.davidanastasov.emtlabproject.model.dto.AuthorDTO;
import com.davidanastasov.emtlabproject.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors")
@Tag(name = "Author Management", description = "API for managing authors") // Swagger Tag
public class AuthorController {

    private final AuthorService authorService;

    @Operation(summary = "Get all authors", description = "Returns a list of all authors")
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @Operation(summary = "Get an author by ID", description = "Fetches an author by their unique ID")
    @GetMapping("{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return authorService.findById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new author", description = "Saves a new author to the database")
    @PostMapping
    public ResponseEntity<Author> save(@RequestBody AuthorDTO author) {
        return authorService.save(author)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Update an existing author", description = "Updates an author's details")
    @PatchMapping("{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody AuthorDTO author) {
        return authorService.update(id, author)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete an author by ID", description = "Removes an author from the database")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAuthorById(@PathVariable Long id) {
        if (authorService.findById(id).isPresent()) {
            authorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
