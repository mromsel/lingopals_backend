package com.romsel.lingopals_backend.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.domain.entities.languages_content.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {

}
