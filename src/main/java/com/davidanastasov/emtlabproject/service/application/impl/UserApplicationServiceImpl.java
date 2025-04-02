package com.davidanastasov.emtlabproject.service.application.impl;

import com.davidanastasov.emtlabproject.model.dto.CreateUserDTO;
import com.davidanastasov.emtlabproject.model.dto.LoginUserDTO;
import com.davidanastasov.emtlabproject.model.dto.UserDTO;
import com.davidanastasov.emtlabproject.service.application.UserApplicationService;
import com.davidanastasov.emtlabproject.service.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserService userService;

    @Override
    public Optional<UserDTO> register(CreateUserDTO user) {
        var savedUser = userService.register(user.username(), user.password(), user.name(), user.surname(), user.role());
        return Optional.of(UserDTO.from(savedUser));
    }

    @Override
    public Optional<UserDTO> login(LoginUserDTO user) {
        var savedUser = userService.login(user.username(), user.password());
        return Optional.of(UserDTO.from(savedUser));
    }
}
