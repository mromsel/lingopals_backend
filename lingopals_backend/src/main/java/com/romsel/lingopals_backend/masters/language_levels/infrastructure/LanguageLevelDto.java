package com.romsel.lingopals_backend.masters.language_levels.infrastructure;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel
 */
@Data
public class LanguageLevelDto {

    private Integer idLevel;
    private String levelName;

}
