package com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.words_related.words.domain.WordRepository;
import com.romsel.lingopals_backend.words_related.words.domain.words_languages.entities.WordAR;
import com.romsel.lingopals_backend.words_related.words.domain.words_languages.repositories.WordARRepository;
import com.romsel.lingopals_backend.words_related.words.infrastructure.WordServiceImpl;

@Service
public class WordARService extends WordServiceImpl<WordAR, Long> {

    @Autowired
    private WordARRepository wordARRepository;

    public WordARService(WordRepository<WordAR, Long> wordRepository) {
        super(wordRepository);
    }
}
