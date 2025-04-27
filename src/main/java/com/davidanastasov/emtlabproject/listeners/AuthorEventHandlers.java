package com.davidanastasov.emtlabproject.listeners;

import com.davidanastasov.emtlabproject.events.AuthorCreatedEvent;
import com.davidanastasov.emtlabproject.events.AuthorDeletedEvent;
import com.davidanastasov.emtlabproject.events.AuthorEditedEvent;
import com.davidanastasov.emtlabproject.service.domain.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorEventHandlers {

    private final AuthorService authorService;

    @EventListener
    public void onAuthorCreated(AuthorCreatedEvent event) {
        authorService.refreshMaterializedView();
    }

    @EventListener
    public void onAuthorEdited(AuthorEditedEvent event) {
        authorService.refreshMaterializedView();
    }

    @EventListener
    public void onAuthorDeleted(AuthorDeletedEvent event) {
        authorService.refreshMaterializedView();
    }
}
