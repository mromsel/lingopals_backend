package com.romsel.lingopal_backend.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopal_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopal_backend.application.exceptions.LanguageException;
import com.romsel.lingopal_backend.domain.entities.languages_content.Language;
import com.romsel.lingopal_backend.domain.repositories.LanguageRepository;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> getAllLanguages() {
        return (List<Language>) languageRepository.findAll();
    }

    public Language getLanguageByID(int idLanguage) {
    return languageRepository.findById(idLanguage).orElseThrow(
            () -> new LanguageException(HttpStatus.NOT_FOUND, List.of(ExceptionMessages.LANGUAGE_NOT_FOUND)));
}
}
