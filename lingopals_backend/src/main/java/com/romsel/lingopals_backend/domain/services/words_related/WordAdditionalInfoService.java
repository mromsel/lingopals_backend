package com.romsel.lingopals_backend.domain.services.words_related;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.domain.entities.words_related.Word;
import com.romsel.lingopals_backend.domain.entities.words_related.WordAdditionalInfo;
import com.romsel.lingopals_backend.domain.repositories.words_related.WordAdditionalInfoRepository;

@Service
public class WordAdditionalInfoService {

    @Autowired
    private WordAdditionalInfoRepository wordAdditionalInfoRepository;

    public WordAdditionalInfo getWordAdditionalInfoByWord(Word word) {
        return wordAdditionalInfoRepository.findByWord(word);
    }

}
