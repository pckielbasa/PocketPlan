package com.pkielbasa.pocketplan.application.dto;

public record CreateUserRequest(
        String username,
        String password,
        String email,
        String firstName,
        String surname
) {}
