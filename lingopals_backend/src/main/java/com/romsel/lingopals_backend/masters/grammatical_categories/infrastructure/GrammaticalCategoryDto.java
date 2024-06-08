package com.romsel.lingopals_backend.masters.grammatical_categories.infrastructure;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.masters.grammatical_categories.domain.GrammaticalCategory
 */
@Data
public class GrammaticalCategoryDto {

    private Integer idGrammaticalCategory;
    private String name;
}
