package com.davidanastasov.emtlabproject.repository;

import com.davidanastasov.emtlabproject.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
