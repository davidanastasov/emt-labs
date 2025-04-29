package com.davidanastasov.emtlabproject.service.application;

import com.davidanastasov.emtlabproject.model.dto.*;

import java.util.List;
import java.util.Optional;

public interface UserApplicationService {
    List<UserDTO> fetchAll();

    Optional<UserDTO> register(CreateUserDTO user);

    Optional<LoginResponseDTO> loginToken(LoginUserDTO user);

    Optional<UserDTO> loginUser(LoginUserDTO user);

    List<BookRentalDTO> getAllUserRentals(String username);
}
