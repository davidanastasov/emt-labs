package com.davidanastasov.emtlabproject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Continent continent;

    public Country(String name, Continent continent) {
        this.name = name;
        this.continent = continent;
    }
}
