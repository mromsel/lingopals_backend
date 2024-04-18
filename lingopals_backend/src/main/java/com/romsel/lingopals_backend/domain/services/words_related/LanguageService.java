package com.romsel.lingopals_backend.domain.services.words_related;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.application.exceptions.words_related.LanguageException;
import com.romsel.lingopals_backend.domain.entities.words_related.Language;
import com.romsel.lingopals_backend.domain.repositories.words_related.LanguageRepository;

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
