package com.davidanastasov.emtlabproject.service.application.impl;

import com.davidanastasov.emtlabproject.model.domain.User;
import com.davidanastasov.emtlabproject.model.dto.*;
import com.davidanastasov.emtlabproject.security.JwtHelper;
import com.davidanastasov.emtlabproject.service.application.UserApplicationService;
import com.davidanastasov.emtlabproject.service.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserService userService;
    private final JwtHelper jwtHelper;

    @Override
    public List<UserDTO> fetchAll() {
        return UserDTO.from(userService.fetchAll());
    }

    @Override
    public Optional<UserDTO> register(CreateUserDTO user) {
        var savedUser = userService.register(user.username(), user.password(), user.name(), user.surname(), user.role());
        return Optional.of(UserDTO.from(savedUser));
    }

    @Override
    public Optional<LoginResponseDTO> loginToken(LoginUserDTO loginUserDTO) {
        User user = userService.login(
                loginUserDTO.username(),
                loginUserDTO.password()
        );

        String token = jwtHelper.generateToken(user);

        return Optional.of(new LoginResponseDTO(token));
    }

    @Override
    public Optional<UserDTO> loginUser(LoginUserDTO user) {
        var savedUser = userService.login(user.username(), user.password());
        return Optional.of(UserDTO.from(savedUser));
    }

    @Override
    public List<BookRentalDTO> getAllUserRentals(String username) {
        return BookRentalDTO.from(userService.getAllUserRentals(username));
    }
}
