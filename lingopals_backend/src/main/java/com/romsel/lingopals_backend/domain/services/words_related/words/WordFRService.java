package com.romsel.lingopals_backend.domain.services.words_related.words;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.domain.entities.words_related.words.WordFR;
import com.romsel.lingopals_backend.domain.repositories.words_related.words.WordFRRepository;
import com.romsel.lingopals_backend.domain.repositories.words_related.words.WordRepository;

@Service
public class WordFRService extends WordServiceImpl<WordFR, Long> {

    @Autowired
    private WordFRRepository wordFRRepository;;

    public WordFRService(WordRepository<WordFR, Long> wordRepository) {
        super(wordRepository);
    }
}
