package com.romsel.lingopal_backend.application.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopal_backend.application.exceptions.LanguageException;
import com.romsel.lingopal_backend.domain.entities.languages_content.Language;
import com.romsel.lingopal_backend.domain.services.LanguageService;

@RestController
@RequestMapping("/api")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("languages")
    public List<Language> getAllLanguage() {
        return languageService.getAllLanguages();
    }

    @GetMapping("languages/{idLanguage}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Integer idLanguage) {
        Language language;

        try {
            language = languageService.getLanguageByID(idLanguage);
        } catch (DataAccessException e) {
            throw new LanguageException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        return new ResponseEntity<>(language, HttpStatus.OK);
    }

}
