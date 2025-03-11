package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.Continent;

public record CountryDTO(
        String name,
        Continent continent
) {}
