package com.romsel.lingopals_backend.users_related.users.infrastructure;

import com.romsel.lingopals_backend.images.infrastructure.ImageDto;
import com.romsel.lingopals_backend.masters.languages.infrastructure.LanguageDto;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.users_related.users.domain.User
 */
@Data
public class UserBasicDto {

    private Long idUser;
    private String username;
    private String email;
    private ImageDto profileImage;
    private LanguageDto preferredLanguage;
    private String timeZone;

}
