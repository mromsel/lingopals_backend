package com.romsel.lingopals_backend.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.domain.entities.languages_content.LanguageLevel;

@Repository
public interface LanguageLevelRepository extends CrudRepository<LanguageLevel, Integer> {

}
