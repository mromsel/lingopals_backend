package com.romsel.lingopal_backend.application.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {
	
    private final LocalDateTime timestamp;
    private final int status;
    private final List<String> errors;
    private final String message;
    private final String trace;
    private final String path;
  
    public ErrorResponse(int status, List<String> errors, String message, String trace, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.errors = errors;
        this.message = message;
        this.trace = trace;
        this.path = path;
    }

}
