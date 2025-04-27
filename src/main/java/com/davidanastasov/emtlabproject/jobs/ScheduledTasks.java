package com.davidanastasov.emtlabproject.jobs;

import com.davidanastasov.emtlabproject.service.domain.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledTasks {
    private final BookService bookService;

    @Scheduled(cron = "0 0 * * * *")
    public void refreshMaterializedView() {
        bookService.refreshMaterializedView();
    }
}
