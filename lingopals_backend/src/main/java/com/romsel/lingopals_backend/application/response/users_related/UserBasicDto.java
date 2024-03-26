package com.romsel.lingopals_backend.application.response.users_related;

import com.romsel.lingopals_backend.domain.entities.words_related.Language;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.users_related.User
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
