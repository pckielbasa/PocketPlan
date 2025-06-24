package com.pkielbasa.pocketplan.application.dto;

public record CreateUserRequest(
        Long id,
        String username,
        String password,
        String email,
        String firstName,
        String surname
) {}
