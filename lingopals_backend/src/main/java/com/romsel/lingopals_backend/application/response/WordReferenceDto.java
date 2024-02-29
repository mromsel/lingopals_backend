package com.romsel.lingopals_backend.application.response;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.languages_content.WordReference
 */
@Data
public class WordReferenceDto {

    private long idWordRef;
    private LanguageLevelDto languageLevel;
    private CategoryDto category;

}
