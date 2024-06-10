package com.romsel.lingopals_backend.words_related.categories.infrastructure;

import com.romsel.lingopals_backend.words_related.word_references.infrastructure.WordReferenceDto;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.words_related.categories.domain.Category
 */
@Data
public class CategoryDto {

    private Integer idCategory;
    private WordReferenceDto namWordReference;

}
