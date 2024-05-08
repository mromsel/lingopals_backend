package com.romsel.lingopals_backend.words_related.word_references.infrastructure;

import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.words_related.categories.infrastructure.CategoryDto;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.words_related.word_references.domain.WordReference
 */
@Data
public class WordReferenceDto {

    private long idWordRef;
    private LanguageLevelDto languageLevel;
    private CategoryDto category;
    private String imageUrl;

}
