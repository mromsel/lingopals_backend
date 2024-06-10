package com.romsel.lingopals_backend.images.domain;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.romsel.lingopals_backend.common.exceptions.BaseException;

public class ImageException extends BaseException {

    public ImageException(HttpStatus httpStatus, List<String> customErrors) {
        super(httpStatus, customErrors);
    }

}
