package com.romsel.lingopals_backend.domain.services.words_related;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.application.exceptions.words_related.WordException;
import com.romsel.lingopals_backend.domain.entities.words_related.Word;
import com.romsel.lingopals_backend.domain.repositories.words_related.WordRepository;

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

    public List<Word> getWordsByWordReferencesAndLanguage(List<Long> idWordRefs, Integer idLanguage) {
        return wordRepository.findAllByWordReferencesAndLanguage(idWordRefs, idLanguage);
    }

}
