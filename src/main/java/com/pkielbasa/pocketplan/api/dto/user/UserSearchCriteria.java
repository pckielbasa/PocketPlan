package com.pkielbasa.pocketplan.api.dto.user;

public record UserSearchCriteria(
        String username,
        String email,
        String firstName,
        String surname,
        String sort,
        String destination
) {}
