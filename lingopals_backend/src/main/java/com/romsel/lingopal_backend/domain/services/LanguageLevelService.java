package com.romsel.lingopal_backend.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopal_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopal_backend.application.exceptions.LanguageLevelException;
import com.romsel.lingopal_backend.domain.entities.languages_content.LanguageLevel;
import com.romsel.lingopal_backend.domain.repositories.LanguageLevelRepository;

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
