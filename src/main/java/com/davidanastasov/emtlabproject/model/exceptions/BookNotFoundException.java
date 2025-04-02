package com.davidanastasov.emtlabproject.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super("Book not found");
    }

    public BookNotFoundException(Long id) {
        super(String.format("Book with id: %s was not found", id));
    }
}
