package com.pkielbasa.pocketplan.api.dto.transaction;

public record TransactionSearchCriteria(
        String name,
        String type,
        String sort,
        String direction
) {}
