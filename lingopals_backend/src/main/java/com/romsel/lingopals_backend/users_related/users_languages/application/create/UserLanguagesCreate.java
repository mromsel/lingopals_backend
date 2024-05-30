package com.romsel.lingopals_backend.users_related.users_languages.application.create;

import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel;
import com.romsel.lingopals_backend.masters.languages.domain.Language;

import lombok.Data;

@Data
public class UserLanguagesCreate {

    private Long idUser;
    private Boolean preferred;
    private Language languageOrigin;
    private Language languageTarget;
    private LanguageLevel languageLevel;

}
