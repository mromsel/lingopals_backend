package com.romsel.lingopals_backend.auth.infrastructure;

import lombok.Data;

@Data
public class UserSignUpDto {

    private String username;
    private String email;
    private String password;
    private Integer idPreferredLanguage;
    private String timeZone;

}
