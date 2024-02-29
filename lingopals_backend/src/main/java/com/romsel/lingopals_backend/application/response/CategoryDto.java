package com.romsel.lingopals_backend.application.response;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.languages_content.Category
 */
@Data
public class CategoryDto {

    private Integer idCategory;
    private WordReferenceDto namWordReference;

}
