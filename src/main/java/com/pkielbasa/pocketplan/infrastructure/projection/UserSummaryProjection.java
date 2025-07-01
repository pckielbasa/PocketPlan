package com.pkielbasa.pocketplan.infrastructure.projection;

public record UserSummaryProjection(
        Long id,
        String username,
        String email,
        String firstName,
        String surname
) {}
