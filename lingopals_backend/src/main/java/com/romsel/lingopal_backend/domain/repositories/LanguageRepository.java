package com.romsel.lingopal_backend.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.romsel.lingopal_backend.domain.entities.languages_content.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer> {
    
}
