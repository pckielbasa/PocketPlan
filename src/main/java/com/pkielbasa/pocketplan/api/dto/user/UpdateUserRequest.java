package com.pkielbasa.pocketplan.api.dto.user;

public record UpdateUserRequest(
        String username,
        String email,
        String firstName,
        String surname
) {}