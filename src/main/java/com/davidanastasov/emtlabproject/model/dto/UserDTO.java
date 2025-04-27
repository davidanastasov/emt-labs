package com.davidanastasov.emtlabproject.model.dto;

import com.davidanastasov.emtlabproject.model.domain.User;
import com.davidanastasov.emtlabproject.model.enumerations.Role;

import java.util.List;

public record UserDTO(
        String name,
        String surname,
        String username,
        Role role
) {

    public User toUser() {
        return new User(username, name, surname, role.name());
    }

    public static UserDTO from(User user) {
        return new UserDTO(user.getName(), user.getSurname(), user.getUsername(), user.getRole());
    }

    public static List<UserDTO> from(List<User> users) {
        return users.stream().map(UserDTO::from).toList();
    }
}
