package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.Country;
import com.davidanastasov.emtlabproject.model.enumerations.Continent;

public record UpdateCountryDTO(
        String name,
        Continent continent
) {

    public Country toCategory() {
        return new Country(name, continent);
    }
}
