package ua.goit.hw8.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.goit.hw8.model.Role;


import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID id;

    @Email
    @NotNull(message = "User's email should not be null")
    private String email;
    @NotNull(message = "User's email should not be null")
    private String password;
    @NotNull(message = "User's email should not be null")
    private String firstName;
    @NotNull(message = "User's email should not be null")
    private String lastName;
    @NotNull(message = "User should have the role")
    private Set<Role> roles;
}
