package com.davidanastasov.emtlabproject.web;

import com.davidanastasov.emtlabproject.model.dto.CountryDTO;
import com.davidanastasov.emtlabproject.model.dto.CreateCountryDTO;
import com.davidanastasov.emtlabproject.model.dto.UpdateCountryDTO;
import com.davidanastasov.emtlabproject.service.application.CountryApplicationService;
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

    private final CountryApplicationService countryApplicationService;

    @Operation(summary = "Get all countries", description = "Returns a list of all countries")
    @GetMapping
    public List<CountryDTO> getAllCountries() {
        return countryApplicationService.findAll();
    }

    @Operation(summary = "Get a country by ID", description = "Fetches a country by its unique ID")
    @GetMapping("{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
        return countryApplicationService.findById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new country", description = "Saves a new country to the database")
    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody CreateCountryDTO country) {
        return countryApplicationService.save(country)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Update an existing country", description = "Updates a country's details")
    @PatchMapping("{id}")
    public ResponseEntity<CountryDTO> update(@PathVariable Long id, @RequestBody UpdateCountryDTO country) {
        return countryApplicationService.update(id, country)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a country by ID", description = "Removes a country from the database")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCountryById(@PathVariable Long id) {
        if (countryApplicationService.findById(id).isPresent()) {
            countryApplicationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

