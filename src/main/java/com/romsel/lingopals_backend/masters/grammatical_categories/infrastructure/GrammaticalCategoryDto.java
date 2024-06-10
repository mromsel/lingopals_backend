package com.romsel.lingopals_backend.masters.grammatical_categories.infrastructure;

import com.romsel.lingopals_backend.masters.grammatical_categories.domain.GrammaticalCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @see com.romsel.lingopals_backend.masters.grammatical_categories.domain.GrammaticalCategory
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GrammaticalCategoryDto {

    private Integer idGrammaticalCategory;
    private String name;

    public static GrammaticalCategoryDto convertToDto(GrammaticalCategory grammaticalCategory) {
        if (grammaticalCategory != null) {
            return GrammaticalCategoryDto.builder()
                    .idGrammaticalCategory(grammaticalCategory.getIdGrammaticalCategory())
                    .name(grammaticalCategory.getName()).build();
        } else {
            return null;
        }
    }
}
