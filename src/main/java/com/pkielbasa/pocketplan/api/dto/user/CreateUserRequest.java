package com.pkielbasa.pocketplan.api.dto.user;

public record CreateUserRequest(
        String username,
        String password,
        String email,
        String firstName,
        String surname
) {}
