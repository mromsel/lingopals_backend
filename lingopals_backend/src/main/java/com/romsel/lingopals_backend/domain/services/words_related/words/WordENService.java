package com.romsel.lingopals_backend.domain.services.words_related.words;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.domain.entities.words_related.words.WordEN;
import com.romsel.lingopals_backend.domain.repositories.words_related.words.WordENRepository;
import com.romsel.lingopals_backend.domain.repositories.words_related.words.WordRepository;

@Service
public class WordENService extends WordServiceImpl<WordEN, Long> {

    @Autowired
    private WordENRepository wordENRepository;

    public WordENService(WordRepository<WordEN, Long> wordRepository) {
        super(wordRepository);
    }

}
