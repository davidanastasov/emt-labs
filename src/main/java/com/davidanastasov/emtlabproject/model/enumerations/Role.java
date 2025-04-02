package com.davidanastasov.emtlabproject.model.enumerations;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    LIBRARIAN,
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
