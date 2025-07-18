package com.pkielbasa.pocketplan.api.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "Username is required")
        String username,

        @NotBlank(message = "Password is required")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        String password,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email, please check again")
        String email,

        @NotBlank(message = "First name is required")
        String firstName,

        @NotBlank(message = "Surname is required")
        String surname
) {}
