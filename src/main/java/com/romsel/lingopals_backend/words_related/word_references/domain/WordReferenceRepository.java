package com.romsel.lingopals_backend.words_related.word_references.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordReferenceRepository extends CrudRepository<WordReference, Long> {

}
