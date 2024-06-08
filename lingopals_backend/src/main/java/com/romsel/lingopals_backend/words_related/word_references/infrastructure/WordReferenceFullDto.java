package com.romsel.lingopals_backend.words_related.word_references.infrastructure;

import com.romsel.lingopals_backend.masters.grammatical_categories.infrastructure.GrammaticalCategoryDto;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.words_related.categories.infrastructure.CategoryDto;
import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.words_related.word_references.domain.WordReference
 */
@Data
public class WordReferenceFullDto {

    private Long idWordRef;
    private String englishWord;
    private String englishDefinition;
    private GrammaticalCategoryDto grammaticalCategory;
    private LanguageLevelDto languageLevel;
    private CategoryDto category;
    private String imageUrl;

}
