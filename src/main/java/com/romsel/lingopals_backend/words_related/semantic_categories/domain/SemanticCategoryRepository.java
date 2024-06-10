package com.romsel.lingopals_backend.words_related.semantic_categories.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemanticCategoryRepository extends CrudRepository<SemanticCategory, Integer> {

}
