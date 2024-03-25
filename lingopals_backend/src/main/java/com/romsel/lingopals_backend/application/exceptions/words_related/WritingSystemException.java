package com.romsel.lingopals_backend.application.exceptions.words_related;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class WritingSystemException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;
    private final List<String> customErrors;

    public WritingSystemException(HttpStatus httpStatus, List<String> customErrors) {
        this.httpStatus = httpStatus;
        this.customErrors = customErrors;
    }

}
