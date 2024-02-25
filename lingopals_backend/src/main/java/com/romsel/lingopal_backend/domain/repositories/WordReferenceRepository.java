package com.romsel.lingopal_backend.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopal_backend.domain.entities.languages_content.WordReference;

@Repository
public interface WordReferenceRepository extends CrudRepository<WordReference, Long> {

}
