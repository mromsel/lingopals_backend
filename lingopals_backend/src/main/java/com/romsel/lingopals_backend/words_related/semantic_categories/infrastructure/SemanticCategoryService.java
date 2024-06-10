package com.romsel.lingopals_backend.words_related.semantic_categories.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategory;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategoryRepository;

@Service
public class SemanticCategoryService {

    @Autowired
    private SemanticCategoryRepository semanticCategoryRepository;

    public List<SemanticCategory> findAll() {
        return (List<SemanticCategory>) semanticCategoryRepository.findAll();
    }
}
