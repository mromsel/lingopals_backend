package com.romsel.lingopals_backend.users_related.users_languages.infrastructure.create;

import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.masters.languages.infrastructure.LanguageDto;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.users_related.users_languages.application.create.UserLanguagesCreate
 */
@Data
public class UserLanguagesCreateDto {

    private Long idUser;
    private Boolean preferred;
    private LanguageDto languageOrigin;
    private LanguageDto languageTarget;
    private LanguageLevelDto languageLevel;
}
