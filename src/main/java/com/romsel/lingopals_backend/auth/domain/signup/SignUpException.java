package com.romsel.lingopals_backend.auth.domain.signup;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.romsel.lingopals_backend.common.exceptions.BaseException;

public class SignUpException extends BaseException {

    public SignUpException(HttpStatus httpStatus, List<String> customErrors) {
        super(httpStatus, customErrors);
    }

}
