package com.romsel.lingopals_backend.words_related.words.domain;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class WordException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;
    private final List<String> customErrors;

    public WordException(HttpStatus httpStatus, List<String> customErrors) {
        this.httpStatus = httpStatus;
        this.customErrors = customErrors;
    }

}
