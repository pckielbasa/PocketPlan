package com.pkielbasa.pocketplan.api.dto.transaction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UpdateTransactionRequest(
        @NotBlank String name,
        String description,
        @NotBlank String type,
        @NotNull BigDecimal fee,
        @NotNull LocalDateTime date
) {}
