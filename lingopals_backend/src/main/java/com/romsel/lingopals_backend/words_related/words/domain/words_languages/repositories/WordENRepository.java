package com.romsel.lingopals_backend.words_related.words.domain.words_languages.repositories;

import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.words_related.words.domain.WordRepository;
import com.romsel.lingopals_backend.words_related.words.domain.words_languages.entities.WordEN;

@Repository
public interface WordENRepository extends WordRepository<WordEN, Long> {

}
