package com.romsel.lingopals_backend.application.response.words_related;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.words_related.LanguageLevel
 */
@Data
public class LanguageLevelDto {

    private Integer idLevel;
    private String levelName;

}
