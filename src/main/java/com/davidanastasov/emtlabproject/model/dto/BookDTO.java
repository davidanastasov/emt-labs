package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.Category;

public record BookDTO(
        String name,
        Category category,
        Long authorId,
        Integer availableCopies
) {}