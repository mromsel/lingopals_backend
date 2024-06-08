package com.romsel.lingopals_backend.masters.grammatical_categories.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrammaticalCategoryRepository extends CrudRepository<GrammaticalCategory, Integer> {

}
