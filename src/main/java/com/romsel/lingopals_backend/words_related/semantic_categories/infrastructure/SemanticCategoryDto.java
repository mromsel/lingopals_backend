package com.romsel.lingopals_backend.words_related.semantic_categories.infrastructure;

import com.romsel.lingopals_backend.images.infrastructure.ImageDto;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SemanticCategoryDto {
    private Integer idSemanticCategory;
    private String englishName;
    private ImageDto image;

    public static SemanticCategoryDto convertToDto(SemanticCategory semanticCategory) {
        if (semanticCategory != null) {
            return SemanticCategoryDto.builder()
                    .idSemanticCategory(semanticCategory.getIdSemanticCategory())
                    .englishName(semanticCategory.getEnglishName())
                    .image(ImageDto.convertToDto(semanticCategory.getImage()))
                    .build();
        } else {
            return null;
        }
    }
}
