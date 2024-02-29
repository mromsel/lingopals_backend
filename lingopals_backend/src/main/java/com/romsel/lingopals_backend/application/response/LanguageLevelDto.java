package com.romsel.lingopals_backend.application.response;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.languages_content.LanguageLevel
 */
@Data
public class LanguageLevelDto {

    private Integer idLevel;
    private String levelName;

}
