package com.davidanastasov.emtlabproject.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class AuthorEditedEvent extends ApplicationEvent {
    private final LocalDateTime when;

    public AuthorEditedEvent(Object source) {
        super(source);
        this.when = LocalDateTime.now();
    }

    public AuthorEditedEvent(Object source, LocalDateTime when) {
        super(source);
        this.when = when;
    }
}
