package com.romsel.lingopals_backend.words_related.word_references.infrastructure;

import com.romsel.lingopals_backend.images.infrastructure.ImageDto;
import com.romsel.lingopals_backend.masters.grammatical_categories.infrastructure.GrammaticalCategoryDto;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.words_related.semantic_categories.infrastructure.SemanticCategoryDto;
import com.romsel.lingopals_backend.words_related.word_references.domain.WordReference;

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
        private SemanticCategoryDto semanticCategory;
        private ImageDto image;

        public static WordReferenceFullDto mapToDto(WordReference wordReference) {
                if (wordReference != null) {
                        WordReferenceFullDto wordReferenceFullDto = new WordReferenceFullDto();
                        wordReferenceFullDto.setIdWordRef(wordReference.getIdWordRef());
                        wordReferenceFullDto.setEnglishWord(wordReference.getEnglishWord());
                        wordReferenceFullDto.setEnglishDefinition(wordReference.getEnglishDefinition());
                        wordReferenceFullDto
                                        .setGrammaticalCategory(GrammaticalCategoryDto
                                                        .convertToDto(wordReference.getGrammaticalCategory()));
                        wordReferenceFullDto
                                        .setLanguageLevel(LanguageLevelDto
                                                        .convertToDto(wordReference.getLanguageLevel()));
                        wordReferenceFullDto
                                        .setSemanticCategory(
                                                        SemanticCategoryDto.convertToDto(
                                                                        wordReference.getSemanticCategory()));
                        wordReferenceFullDto.setImage(ImageDto.convertToDto(wordReference.getImage()));
                        return wordReferenceFullDto;
                } else {
                        return null;
                }
        }

}
