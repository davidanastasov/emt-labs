package com.davidanastasov.emtlabproject.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException() {
        super("Author not found");
    }

    public AuthorNotFoundException(Long id) {
        super(String.format("Author with id: %s was not found", id));
    }
}
