package com.romsel.lingopals_backend.application.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class LanguageLevelException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;
    private final List<String> customErrors;

    public LanguageLevelException(HttpStatus httpStatus, List<String> customErrors) {
        this.httpStatus = httpStatus;
        this.customErrors = customErrors;
    }

}
