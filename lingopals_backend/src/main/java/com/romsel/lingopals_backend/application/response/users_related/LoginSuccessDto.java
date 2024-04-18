package com.romsel.lingopals_backend.application.response.users_related;

import lombok.Data;

@Data
public class LoginSuccessDto {

    private String token;
    private Long idUser;

}
