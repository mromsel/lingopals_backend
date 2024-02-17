package com.romsel.lingopal_backend.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.romsel.lingopal_backend.domain.entities.languages_content.WritingSystem;

public interface WritingSystemRepository extends CrudRepository<WritingSystem, Integer> {
    
}
