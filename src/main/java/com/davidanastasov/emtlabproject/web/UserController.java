package com.davidanastasov.emtlabproject.web;

import com.davidanastasov.emtlabproject.model.domain.User;
import com.davidanastasov.emtlabproject.model.dto.*;
import com.davidanastasov.emtlabproject.model.exceptions.InvalidUsernameOrPasswordException;
import com.davidanastasov.emtlabproject.service.application.UserApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User API", description = "Endpoints for user authentication and registration") // Swagger tag
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationService userApplicationService;

    @Operation(
            summary = "Fetch all users",
            description = "Retrieves a list of all users."
    )
    @GetMapping("/fetch")
    public List<UserDTO> fetchAll() {
        return userApplicationService.fetchAll();
    }

    @Operation(summary = "Register a new user", description = "Creates a new user account")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User registered successfully"
            ), @ApiResponse(
                    responseCode = "400", description = "Invalid input or passwords do not match"
            )}
    )
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody CreateUserDTO createUserDto) {
        return userApplicationService.register(createUserDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @Operation(summary = "User login", description = "Authenticates a user and starts a session")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User authenticated successfully"
            ), @ApiResponse(responseCode = "401", description = "Invalid username or password")}
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginUserDTO loginUserDTO) {
        try {
            return userApplicationService.loginToken(loginUserDTO)
                    .map(ResponseEntity::ok)
                    .orElseThrow(InvalidUsernameOrPasswordException::new);
        } catch (InvalidUsernameOrPasswordException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @Operation(summary = "User login", description = "Authenticates a user and starts a session")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User authenticated successfully"
            ), @ApiResponse(responseCode = "401", description = "Invalid username or password")}
    )
    @PostMapping("/login-form")
    public ResponseEntity<UserDTO> loginForm(HttpServletRequest request) {
        UserDTO displayUserDto = userApplicationService
                .loginUser(new LoginUserDTO(request.getParameter("username"), request.getParameter("password")))
                .orElseThrow(InvalidUsernameOrPasswordException::new);

        request.getSession().setAttribute("user", displayUserDto.toUser());
        return ResponseEntity.ok(displayUserDto);
    }

    @Operation(summary = "User logout", description = "Ends the user's session")
    @ApiResponse(responseCode = "200", description = "User logged out successfully")
    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }

    @GetMapping("/rentals")
    public List<BookRentalDTO> getUserRentals(Authentication authentication) {
        try {
            var user = (User) authentication.getPrincipal();
            return userApplicationService.getAllUserRentals(user.getUsername());
        } catch (RuntimeException exception) {
            return null;
        }
    }
}