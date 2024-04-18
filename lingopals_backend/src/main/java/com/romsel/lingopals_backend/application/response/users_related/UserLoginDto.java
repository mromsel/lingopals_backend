package com.romsel.lingopals_backend.application.response.users_related;

import lombok.Data;

@Data
public class UserLoginDto {

    private String usernameOrEmail;
    private String password;
    private String timeZone;
}
