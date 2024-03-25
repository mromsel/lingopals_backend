package com.romsel.lingopals_backend.domain.repositories.words_related;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.domain.entities.words_related.WritingSystem;

@Repository
public interface WritingSystemRepository extends CrudRepository<WritingSystem, Integer> {

}
