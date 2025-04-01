package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.enumerations.Continent;

public record CountryDTO(
        String name,
        Continent continent
) {}
