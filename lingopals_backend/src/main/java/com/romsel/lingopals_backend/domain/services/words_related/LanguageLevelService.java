package com.romsel.lingopals_backend.domain.services.words_related;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.application.exceptions.words_related.LanguageLevelException;
import com.romsel.lingopals_backend.domain.entities.words_related.LanguageLevel;
import com.romsel.lingopals_backend.domain.repositories.words_related.LanguageLevelRepository;

@Service
public class LanguageLevelService {

    @Autowired
    private LanguageLevelRepository languageLevelRepository;

    public List<LanguageLevel> getAllLanguageLevels() {
        return (List<LanguageLevel>) languageLevelRepository.findAll();
    }

    public LanguageLevel getLanguageLevelByID(Integer idLanguageLevel) {
        return languageLevelRepository.findById(idLanguageLevel)
                .orElseThrow(() -> new LanguageLevelException(HttpStatus.NOT_FOUND,
                        List.of(ExceptionMessages.LANGUAGE_LEVEL_NOT_FOUND)));
    }

}
