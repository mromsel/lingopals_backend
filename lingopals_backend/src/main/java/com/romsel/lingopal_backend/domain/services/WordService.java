package com.romsel.lingopal_backend.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopal_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopal_backend.application.exceptions.WordException;
import com.romsel.lingopal_backend.domain.entities.languages_content.Word;
import com.romsel.lingopal_backend.domain.repositories.WordRepository;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private LanguageService languageService;

    public List<Word> getAllWords() {
        return (List<Word>) wordRepository.findAll();
    }

    public List<Word> getAllWordsByLanguage(int idLanguage) {
        return wordRepository.findByLanguage(languageService.getLanguageByID(idLanguage));
    }

    public Word getWordById(long idWord) {
        return wordRepository.findById(idWord)
                .orElseThrow(() -> new WordException(HttpStatus.NOT_FOUND, List.of(ExceptionMessages.WORD_NOT_FOUND)));
    }

}
