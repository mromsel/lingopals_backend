package com.romsel.lingopals_backend.words_related.semantic_categories.domain;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.romsel.lingopals_backend.common.exceptions.BaseException;

public class SemanticCategoryException extends BaseException {

    public SemanticCategoryException(HttpStatus httpStatus, List<String> customErrors) {
        super(httpStatus, customErrors);
    }
}
