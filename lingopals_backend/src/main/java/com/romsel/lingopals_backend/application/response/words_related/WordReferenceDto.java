package com.romsel.lingopals_backend.application.response.words_related;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.words_related.WordReference
 */
@Data
public class WordReferenceDto {

    private long idWordRef;
    private LanguageLevelDto languageLevel;
    private CategoryDto category;

}
