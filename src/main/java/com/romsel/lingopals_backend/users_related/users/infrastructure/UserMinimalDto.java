package com.romsel.lingopals_backend.users_related.users.infrastructure;

import lombok.Data;

@Data
public class UserMinimalDto {
    private Long idUser;
    private String username;
}
