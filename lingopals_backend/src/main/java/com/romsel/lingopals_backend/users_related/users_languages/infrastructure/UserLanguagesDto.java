package com.romsel.lingopals_backend.users_related.users_languages.infrastructure;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.masters.languages.infrastructure.LanguageDto;
import com.romsel.lingopals_backend.users_related.users.infrastructure.UserMinimalDto;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages
 */
@Data
public class UserLanguagesDto {

    private Long idUserLanguages;
    private UserMinimalDto user;
    private LanguageDto languageTarget;
    private LanguageDto languageOrigin;
    private ZonedDateTime startDate;
    private LanguageLevelDto languageLevel;

}
