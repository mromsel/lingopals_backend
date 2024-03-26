package com.romsel.lingopals_backend.application.response.users_related;

import lombok.Data;

@Data
public class UserSignUpDto {

    private String username;
    private String email;
    private String password;
    private Integer idPreferredLanguage;
    private String timeZone;

}
