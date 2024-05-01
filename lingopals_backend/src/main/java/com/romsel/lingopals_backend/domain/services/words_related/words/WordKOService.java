package com.romsel.lingopals_backend.domain.services.words_related.words;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.domain.entities.words_related.words.WordKO;
import com.romsel.lingopals_backend.domain.repositories.words_related.words.WordKORepository;
import com.romsel.lingopals_backend.domain.repositories.words_related.words.WordRepository;

@Service
public class WordKOService extends WordServiceImpl<WordKO, Long> {

    @Autowired
    private WordKORepository wordKORepository;

    public WordKOService(WordRepository<WordKO, Long> wordRepository) {
        super(wordRepository);
    }
}
