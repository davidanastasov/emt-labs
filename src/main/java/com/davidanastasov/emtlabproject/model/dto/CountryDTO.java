package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.Country;
import com.davidanastasov.emtlabproject.model.enumerations.Continent;

import java.util.List;

public record CountryDTO(
        Long id,
        String name,
        Continent continent
) {

    public static CountryDTO from(Country country) {
        return new CountryDTO(country.getId(), country.getName(), country.getContinent());
    }

    public static List<CountryDTO> from(List<Country> countries) {
        return countries.stream().map(CountryDTO::from).toList();
    }
}
