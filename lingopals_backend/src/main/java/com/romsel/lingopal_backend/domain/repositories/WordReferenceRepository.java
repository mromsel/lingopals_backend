package com.romsel.lingopal_backend.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.romsel.lingopal_backend.domain.entities.languages_content.WordReference;

public interface WordReferenceRepository extends CrudRepository<WordReference, Long> {
    
}
