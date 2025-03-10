package com.davidanastasov.emtlabproject.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    LIBRARIAN;

    @Override
    public String getAuthority() {
        return name();
    }
}
