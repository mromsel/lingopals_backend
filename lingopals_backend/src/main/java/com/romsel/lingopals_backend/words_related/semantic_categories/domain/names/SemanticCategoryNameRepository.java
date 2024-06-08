package com.romsel.lingopals_backend.words_related.semantic_categories.domain.names;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.romsel.lingopals_backend.masters.languages.domain.Language;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategory;

@Repository
public interface SemanticCategoryNameRepository extends CrudRepository<SemanticCategoryName, Integer> {

    SemanticCategoryName findBySemanticCategoryAndLanguage(SemanticCategory semanticCategory, Language language);
}
