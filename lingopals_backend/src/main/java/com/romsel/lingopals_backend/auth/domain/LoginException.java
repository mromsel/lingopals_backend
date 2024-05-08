package com.romsel.lingopals_backend.auth.domain;

import java.util.List;

import lombok.Getter;

@Getter
public class LoginException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final List<String> customErrors;

    public LoginException(List<String> customErrors) {
        this.customErrors = customErrors;
    }
}
