package com.pkielbasa.pocketplan.api.dto.criteria;

public record TransactionSearchCriteria(
        String name,
        String type,
        Long budgetId,
        String sort,
        String direction
) {}
