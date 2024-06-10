package com.romsel.lingopals_backend.masters.language_levels.infrastructure;

import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @see com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LanguageLevelDto {

    private Integer idLevel;
    private String levelName;

    public static LanguageLevelDto convertToDto(LanguageLevel languageLevel) {
        if (languageLevel != null) {
            return LanguageLevelDto.builder()
                    .idLevel(languageLevel.getIdLevel())
                    .levelName(languageLevel.getLevelName())
                    .build();
        } else {
            return null;
        }
    }
}
