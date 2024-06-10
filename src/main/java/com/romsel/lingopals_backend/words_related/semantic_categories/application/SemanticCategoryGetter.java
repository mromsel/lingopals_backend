package com.romsel.lingopals_backend.words_related.semantic_categories.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategory;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategoryException;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategoryRepository;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.names.SemanticCategoryNameRepository;

@Service
public class SemanticCategoryGetter {

    @Autowired
    private SemanticCategoryRepository semanticCategoryRepository;

    @Autowired
    private SemanticCategoryNameRepository semanticCategoryNameRepository;

    public SemanticCategory getFullCategory(Integer idCategory, UserLanguages userLanguages) {
        SemanticCategory semanticCategory = semanticCategoryRepository.findById(idCategory).orElseThrow(
                () -> new SemanticCategoryException(HttpStatus.NOT_FOUND, List.of("Semantic category not found")));

        String nameInOriginLanguage = semanticCategoryNameRepository.findBySemanticCategoryAndLanguage(semanticCategory,
                userLanguages.getLanguageOrigin()).getName();
        String nameInTargetLanguage = semanticCategoryNameRepository.findBySemanticCategoryAndLanguage(semanticCategory,
                userLanguages.getLanguageTarget()).getName();
        semanticCategory.setNameInOriginLanguage(nameInOriginLanguage);
        semanticCategory.setNameInTargetLanguage(nameInTargetLanguage);
        return semanticCategory;
    }
}
