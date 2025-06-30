package com.pkielbasa.pocketplan.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        int code,
        String error,
        String message,
        String path

) {}
