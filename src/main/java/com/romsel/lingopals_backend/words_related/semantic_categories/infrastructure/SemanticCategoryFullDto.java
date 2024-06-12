package com.romsel.lingopals_backend.words_related.semantic_categories.infrastructure;

import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategory;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SemanticCategoryFullDto {

    private Integer idSemanticCategory;
    private String englishName;
    private String nameInOriginLanguage;
    private String nameInTargetLanguage;

    public static SemanticCategoryFullDto convertToDto(SemanticCategory semanticCategory) {
        if (semanticCategory != null) {
            return SemanticCategoryFullDto.builder()
                    .idSemanticCategory(semanticCategory.getIdSemanticCategory())
                    .englishName(semanticCategory.getEnglishName())
                    .nameInOriginLanguage(semanticCategory.getNameInOriginLanguage())
                    .nameInTargetLanguage(semanticCategory.getNameInTargetLanguage())
                    .build();
        } else {
            return null;
        }
    }
}
