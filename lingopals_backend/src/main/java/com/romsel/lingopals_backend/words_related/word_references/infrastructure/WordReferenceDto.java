package com.romsel.lingopals_backend.words_related.word_references.infrastructure;

import com.romsel.lingopals_backend.masters.grammatical_categories.infrastructure.GrammaticalCategoryDto;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.words_related.semantic_categories.infrastructure.SemanticCategoryDto;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.words_related.word_references.domain.WordReference
 */
@Data
public class WordReferenceDto {

    private Long idWordRef;
    private GrammaticalCategoryDto grammaticalCategory;
    private LanguageLevelDto languageLevel;
    private SemanticCategoryDto semanticCategory;
    private String imageUrl;

}
