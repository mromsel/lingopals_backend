package com.romsel.lingopals_backend.masters.activity_types.domain;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.romsel.lingopals_backend.common.exceptions.BaseException;

public class ActivityTypeException extends BaseException {

    public ActivityTypeException(HttpStatus httpStatus, List<String> customErrors) {
        super(httpStatus, customErrors);
    }

}
