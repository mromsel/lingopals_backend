package com.romsel.lingopal_backend.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopal_backend.domain.entities.languages_content.WritingSystem;

@Repository
public interface WritingSystemRepository extends CrudRepository<WritingSystem, Integer> {

}
