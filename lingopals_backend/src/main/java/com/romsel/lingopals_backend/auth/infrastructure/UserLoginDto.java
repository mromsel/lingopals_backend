package com.romsel.lingopals_backend.auth.infrastructure;

import lombok.Data;

@Data
public class UserLoginDto {

    private String usernameOrEmail;
    private String password;
    private String timeZone;
}
