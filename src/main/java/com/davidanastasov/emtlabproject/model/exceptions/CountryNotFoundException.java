package com.davidanastasov.emtlabproject.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException() {
        super("Country not found");
    }

    public CountryNotFoundException(Long id) {
        super(String.format("Country with id: %s was not found", id));
    }
}
