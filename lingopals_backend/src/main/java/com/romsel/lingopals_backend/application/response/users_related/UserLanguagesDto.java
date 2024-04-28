package com.romsel.lingopals_backend.application.response.users_related;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.application.response.words_related.LanguageDto;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.users_related.UserLanguages
 */
@Data
public class UserLanguagesDto {

    private Long idUser;
    private LanguageDto languageTarget;
    private LanguageDto languageOrigin;
    private ZonedDateTime startDate;

}
