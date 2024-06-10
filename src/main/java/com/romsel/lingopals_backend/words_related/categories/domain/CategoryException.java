package com.romsel.lingopals_backend.words_related.categories.domain;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CategoryException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;
    private final List<String> customErrors;

    public CategoryException(HttpStatus httpStatus, List<String> customErrors) {
        this.httpStatus = httpStatus;
        this.customErrors = customErrors;
    }

}
