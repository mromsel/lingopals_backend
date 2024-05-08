package com.romsel.lingopals_backend.masters.language_levels.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageLevelRepository extends CrudRepository<LanguageLevel, Integer> {

}
