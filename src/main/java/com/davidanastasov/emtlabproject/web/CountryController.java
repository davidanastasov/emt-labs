package com.davidanastasov.emtlabproject.web;

import com.davidanastasov.emtlabproject.model.Country;
import com.davidanastasov.emtlabproject.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/countries")
@Tag(name = "Country Management", description = "API for managing countries") // Swagger Tag
public class CountryController {

    private final CountryService countryService;

    @Operation(summary = "Get all countries", description = "Returns a list of all countries")
    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.findAll();
    }

    @Operation(summary = "Get a country by ID", description = "Fetches a country by its unique ID")
    @GetMapping("{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        return countryService.findById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new country", description = "Saves a new country to the database")
    @PostMapping
    public ResponseEntity<Country> save(@RequestBody Country country) {
        return countryService.save(country)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Update an existing country", description = "Updates a country's details")
    @PutMapping("{id}")
    public ResponseEntity<Country> update(@PathVariable Long id, @RequestBody Country country) {
        return countryService.update(id, country)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a country by ID", description = "Removes a country from the database")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCountryById(@PathVariable Long id) {
        if (countryService.findById(id).isPresent()) {
            countryService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

