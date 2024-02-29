package com.romsel.lingopal_backend.application.response;

import lombok.Data;

/**
 * @see com.romsel.lingopal_backend.domain.entities.languages_content.Category
 */
@Data
public class CategoryDto {

    private Integer idCategory;
    private WordReferenceDto namWordReference;

}
