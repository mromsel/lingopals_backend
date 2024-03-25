package com.romsel.lingopals_backend.application.response.words_related;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.words_related.Category
 */
@Data
public class CategoryDto {

    private Integer idCategory;
    private WordReferenceDto namWordReference;

}
