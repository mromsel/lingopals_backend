package com.romsel.lingopals_backend.users_related.users.infrastructure;

import com.romsel.lingopals_backend.masters.languages.domain.Language;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.users_related.users.domain.User
 */
@Data
public class UserBasicDto {

    private Long idUser;
    private String username;
    private String email;
    private String profileImageUrl;
    private Language preferredLanguage;
    private String timeZone;

}
