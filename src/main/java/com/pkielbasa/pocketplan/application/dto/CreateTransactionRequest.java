package com.pkielbasa.pocketplan.application.dto;

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
