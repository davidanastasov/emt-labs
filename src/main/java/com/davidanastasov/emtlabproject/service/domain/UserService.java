package com.davidanastasov.emtlabproject.service.domain;

import com.davidanastasov.emtlabproject.model.domain.User;
import com.davidanastasov.emtlabproject.model.enumerations.Role;

import java.util.Optional;

public interface UserService {
    User register(String username, String password, String name, String surname, Role role);

    User login(String username, String password);

    Optional<User> findByUsername(String username);
}
