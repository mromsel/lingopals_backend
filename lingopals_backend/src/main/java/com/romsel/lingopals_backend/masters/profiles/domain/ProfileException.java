package com.romsel.lingopals_backend.masters.profiles.domain;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.romsel.lingopals_backend.common.exceptions.BaseException;

public class ProfileException extends BaseException {

    public ProfileException(HttpStatus httpStatus, List<String> customErrors) {
        super(httpStatus, customErrors);
    }

}
