package com.romsel.lingopals_backend.words_related.semantic_categories.infrastructure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SemanticCategoryFullDto {

    private Integer idSemanticCategory;
    private String englishName;
    private String nameInOriginLanguage;
    private String nameInTargetLanguage;
}
