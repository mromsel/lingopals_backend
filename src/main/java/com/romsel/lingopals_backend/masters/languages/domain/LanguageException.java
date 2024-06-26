package com.romsel.lingopals_backend.masters.languages.domain;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class LanguageException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;
    private final List<String> customErrors;

    public LanguageException(HttpStatus httpStatus, List<String> customErrors) {
        this.httpStatus = httpStatus;
        this.customErrors = customErrors;
    }

}