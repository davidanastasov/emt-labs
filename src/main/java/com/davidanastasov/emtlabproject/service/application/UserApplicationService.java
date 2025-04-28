package com.davidanastasov.emtlabproject.service.application;

import com.davidanastasov.emtlabproject.model.dto.CreateUserDTO;
import com.davidanastasov.emtlabproject.model.dto.LoginResponseDTO;
import com.davidanastasov.emtlabproject.model.dto.LoginUserDTO;
import com.davidanastasov.emtlabproject.model.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserApplicationService {
    List<UserDTO> fetchAll();

    Optional<UserDTO> register(CreateUserDTO user);

    Optional<LoginResponseDTO> loginToken(LoginUserDTO user);

    Optional<UserDTO> loginUser(LoginUserDTO user);
}
