package com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.words_related.words.domain.WordRepository;
import com.romsel.lingopals_backend.words_related.words.domain.words_languages.entities.WordES;
import com.romsel.lingopals_backend.words_related.words.domain.words_languages.repositories.WordESRepository;
import com.romsel.lingopals_backend.words_related.words.infrastructure.WordServiceImpl;

@Service
public class WordESService extends WordServiceImpl<WordES, Long> {

    @Autowired
    private WordESRepository wordESRepository;

    public WordESService(WordRepository<WordES, Long> wordRepository) {
        super(wordRepository);
    }

}
