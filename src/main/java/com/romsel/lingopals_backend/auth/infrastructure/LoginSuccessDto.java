package com.romsel.lingopals_backend.auth.infrastructure;

import lombok.Data;

@Data
public class LoginSuccessDto {

    private String token;
    private Long idUser;

}
