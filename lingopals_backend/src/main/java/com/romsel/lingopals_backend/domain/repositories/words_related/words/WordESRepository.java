package com.romsel.lingopals_backend.domain.repositories.words_related.words;

import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.domain.entities.words_related.words.WordES;

@Repository
public interface WordESRepository extends WordRepository<WordES, Long> {

}
