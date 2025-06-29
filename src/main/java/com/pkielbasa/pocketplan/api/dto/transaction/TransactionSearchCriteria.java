package com.pkielbasa.pocketplan.api.dto.transaction;

public record TransactionSearchCriteria(
        String name,
        String type,
        Long budgetId,
        String sort,
        String direction
) {}
