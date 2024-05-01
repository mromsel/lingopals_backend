package com.romsel.lingopals_backend.domain.services.words_related.words;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.domain.entities.words_related.words.WordAR;
import com.romsel.lingopals_backend.domain.repositories.words_related.words.WordARRepository;
import com.romsel.lingopals_backend.domain.repositories.words_related.words.WordRepository;

@Service
public class WordARService extends WordServiceImpl<WordAR, Long> {

    @Autowired
    private WordARRepository wordARRepository;

    public WordARService(WordRepository<WordAR, Long> wordRepository) {
        super(wordRepository);
    }
}
