package com.romsel.lingopals_backend.words_related.words.domain.words_languages.repositories;

import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.words_related.words.domain.WordRepository;
import com.romsel.lingopals_backend.words_related.words.domain.words_languages.entities.WordKO;

@Repository
public interface WordKORepository extends WordRepository<WordKO, Long> {

}
