package com.davidanastasov.emtlabproject.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class AuthorCreatedEvent extends ApplicationEvent {
    private final LocalDateTime when;

    public AuthorCreatedEvent(Object source) {
        super(source);
        this.when = LocalDateTime.now();
    }

    public AuthorCreatedEvent(Object source, LocalDateTime when) {
        super(source);
        this.when = when;
    }
}
