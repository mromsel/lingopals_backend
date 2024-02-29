package com.romsel.lingopals_backend.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.application.exceptions.WordAdditionalInfoException;
import com.romsel.lingopals_backend.domain.entities.languages_content.Word;
import com.romsel.lingopals_backend.domain.entities.languages_content.WordAdditionalInfo;
import com.romsel.lingopals_backend.domain.repositories.WordAdditionalInfoRepository;

@Service
public class WordAdditionalInfoService {

    @Autowired
    private WordAdditionalInfoRepository wordAdditionalInfoRepository;

    public WordAdditionalInfo getWordAdditionalInfoByWord(Word word) {
        return wordAdditionalInfoRepository.findByWord(word);
    }

}
