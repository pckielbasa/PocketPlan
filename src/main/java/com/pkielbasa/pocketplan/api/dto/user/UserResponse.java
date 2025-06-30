package com.pkielbasa.pocketplan.api.dto.user;

public record UserResponse(
        Long id,
        String username,
        String email,
        String firstName,
        String surname
) {}
