package com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.words_related.words.domain.WordRepository;
import com.romsel.lingopals_backend.words_related.words.domain.words_languages.entities.WordFR;
import com.romsel.lingopals_backend.words_related.words.domain.words_languages.repositories.WordFRRepository;
import com.romsel.lingopals_backend.words_related.words.infrastructure.WordServiceImpl;

@Service
public class WordFRService extends WordServiceImpl<WordFR, Long> {

    @Autowired
    private WordFRRepository wordFRRepository;;

    public WordFRService(WordRepository<WordFR, Long> wordRepository) {
        super(wordRepository);
    }
}
