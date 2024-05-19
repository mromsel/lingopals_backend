package com.romsel.lingopals_backend.users_related.users.infrastructure;

import java.util.List;

import com.romsel.lingopals_backend.masters.languages.infrastructure.LanguageDto;
import com.romsel.lingopals_backend.users_related.users_languages.infrastructure.UserLanguagesDto;

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
    private LanguageDto preferredLanguage;
    private String timeZone;

}
