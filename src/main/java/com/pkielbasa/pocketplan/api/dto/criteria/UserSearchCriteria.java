package com.pkielbasa.pocketplan.api.dto.criteria;

public record UserSearchCriteria(
        String username,
        String email,
        String firstName,
        String surname,
        String sort,
        String destination
) {}
