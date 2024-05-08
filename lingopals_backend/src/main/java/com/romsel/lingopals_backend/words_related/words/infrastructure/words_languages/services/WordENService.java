package com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.words_related.words.domain.WordRepository;
import com.romsel.lingopals_backend.words_related.words.domain.words_languages.entities.WordEN;
import com.romsel.lingopals_backend.words_related.words.domain.words_languages.repositories.WordENRepository;
import com.romsel.lingopals_backend.words_related.words.infrastructure.WordServiceImpl;

@Service
public class WordENService extends WordServiceImpl<WordEN, Long> {

    @Autowired
    private WordENRepository wordENRepository;

    public WordENService(WordRepository<WordEN, Long> wordRepository) {
        super(wordRepository);
    }

}
