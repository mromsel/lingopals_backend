package com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.words_related.words.domain.WordRepository;
import com.romsel.lingopals_backend.words_related.words.domain.words_languages.entities.WordKO;
import com.romsel.lingopals_backend.words_related.words.domain.words_languages.repositories.WordKORepository;
import com.romsel.lingopals_backend.words_related.words.infrastructure.WordServiceImpl;

@Service
public class WordKOService extends WordServiceImpl<WordKO, Long> {

    @SuppressWarnings("unused")
    @Autowired
    private WordKORepository wordKORepository;

    public WordKOService(WordRepository<WordKO, Long> wordRepository) {
        super(wordRepository);
    }
}
