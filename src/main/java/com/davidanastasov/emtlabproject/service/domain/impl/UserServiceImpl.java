package com.davidanastasov.emtlabproject.service.domain.impl;

import com.davidanastasov.emtlabproject.model.domain.User;
import com.davidanastasov.emtlabproject.model.enumerations.Role;
import com.davidanastasov.emtlabproject.repository.UserRepository;
import com.davidanastasov.emtlabproject.service.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(String username, String password, String name, String surname, Role role) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            return null;

        if (userRepository.findByUsername(username).isPresent())
            return null;

        User user = new User(username, passwordEncoder.encode(password), name, surname, role);

        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return null;
        }

        var passwordHash = passwordEncoder.encode(password);
        return userRepository.findByUsernameAndPassword(username, passwordHash).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
