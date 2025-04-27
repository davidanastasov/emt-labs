package com.davidanastasov.emtlabproject.web;

import com.davidanastasov.emtlabproject.model.dto.*;
import com.davidanastasov.emtlabproject.service.application.AuthorApplicationService;
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

    private final AuthorApplicationService authorApplicationService;

    @Operation(summary = "Get all authors", description = "Returns a list of all authors")
    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorApplicationService.findAll();
    }

    @Operation(summary = "Get an author by ID", description = "Fetches an author by their unique ID")
    @GetMapping("{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id) {
        return authorApplicationService.findById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Get author counts per country",
            description = "Retrieves a list showing the number of authors grouped by their country."
    )
    @GetMapping("by-country")
    public List<AuthorCountsPerCountryDTO> getAuthorCountsPerCountry() {
        return authorApplicationService.getAuthorCountsPerCountry();
    }

    @Operation(
            summary = "Get all author names",
            description = "Retrieves a list of all authors' names."
    )
    @GetMapping("names")
    public List<AuthorNameDTO> getAuthorNames() {
        return authorApplicationService.getAuthorNames();
    }

    @Operation(summary = "Create a new author", description = "Saves a new author to the database")
    @PostMapping
    public ResponseEntity<AuthorDTO> save(@RequestBody CreateAuthorDTO author) {
        return authorApplicationService.save(author)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Update an existing author", description = "Updates an author's details")
    @PatchMapping("{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable Long id, @RequestBody UpdateAuthorDTO author) {
        return authorApplicationService.update(id, author)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete an author by ID", description = "Removes an author from the database")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAuthorById(@PathVariable Long id) {
        if (authorApplicationService.findById(id).isPresent()) {
            authorApplicationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
