package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.enumerations.Role;

public record CreateUserDTO(
        String name,
        String surname,
        String username,
        String password,
        Role role
) {}
