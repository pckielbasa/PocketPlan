package com.pkielbasa.pocketplan.api.dto.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateTransactionRequest(
        Long budgetId,
        String name,
        String description,
        String type,
        BigDecimal fee,
        LocalDateTime date
) {}
