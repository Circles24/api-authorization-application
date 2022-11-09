package com.cs.cdw.web.apiauthorization.error;

import java.sql.Timestamp;
import java.util.UUID;

public enum ErrorBuilder {
    application_not_found("application not found", 404, "application_not_found", "000-001"),
    internal_server_error("something went wrong", 500, "internal_server_error", "000-002"),
    api_not_found("api not found", 404, "api_not_found", "000-003"),;

    private final String message;
    private final int statusCode;
    private final String errorName;
    private final String errorCode;

    private static final String APPLICATION_NAME = "api-authorization-application";

    public Error build() {
        String uuid = UUID.randomUUID().toString();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return Error.builder()
                .id(uuid)
                .message(message)
                .statusCode(statusCode)
                .errorName(errorName)
                .errorCode(errorCode)
                .source(APPLICATION_NAME)
                .timestamp(timestamp)
                .build();
    }

    ErrorBuilder(String message, int statusCode, String errorName, String errorCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.errorName = errorName;
        this.errorCode = errorCode;
    }
}

