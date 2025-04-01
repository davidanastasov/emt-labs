package com.davidanastasov.emtlabproject.service.application;

import com.davidanastasov.emtlabproject.model.dto.CreateUserDTO;
import com.davidanastasov.emtlabproject.model.dto.LoginUserDTO;
import com.davidanastasov.emtlabproject.model.dto.UserDTO;

import java.util.Optional;

public interface UserApplicationService {
    Optional<UserDTO> register(CreateUserDTO user);

    Optional<UserDTO> login(LoginUserDTO user);

    Optional<UserDTO> findByUsername(String username);
}
