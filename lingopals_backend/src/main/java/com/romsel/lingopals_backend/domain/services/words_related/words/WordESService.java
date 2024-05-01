package com.romsel.lingopals_backend.domain.services.words_related.words;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.domain.entities.words_related.words.WordES;
import com.romsel.lingopals_backend.domain.repositories.words_related.words.WordESRepository;
import com.romsel.lingopals_backend.domain.repositories.words_related.words.WordRepository;

@Service
public class WordESService extends WordServiceImpl<WordES, Long> {

    @Autowired
    private WordESRepository wordESRepository;

    public WordESService(WordRepository<WordES, Long> wordRepository) {
        super(wordRepository);
    }

}
