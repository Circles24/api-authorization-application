package com.cs.cdw.web.apiauthorization.error;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class ErrorResponse {
    private String id;
    private String message;
    private int statusCode;
    private String errorName;
    private String errorCode;
    private String source;
    private Timestamp timestamp;
}
