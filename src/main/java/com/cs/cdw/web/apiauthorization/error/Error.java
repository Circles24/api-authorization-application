package com.cs.cdw.web.apiauthorization.error;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Error extends RuntimeException {
    private String id;
    private String message;
    private int statusCode;
    private String errorName;
    private String errorCode;
    private String source;
    private Timestamp timestamp;
}

