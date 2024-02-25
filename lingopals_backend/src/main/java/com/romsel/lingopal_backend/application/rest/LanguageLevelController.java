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

import com.romsel.lingopal_backend.application.exceptions.LanguageLevelException;
import com.romsel.lingopal_backend.domain.entities.languages_content.LanguageLevel;
import com.romsel.lingopal_backend.domain.services.LanguageLevelService;

@RestController
@RequestMapping("/api")
public class LanguageLevelController {

    @Autowired
    private LanguageLevelService languageLevelService;

    @GetMapping("language-levels")
    public List<LanguageLevel> getAllLanguageLevels() {
        return languageLevelService.getAllLanguageLevels();
    }

    @GetMapping("language-levels/{idLanguageLevel}")
    public ResponseEntity<LanguageLevel> getLanguageLevelById(@PathVariable int idLanguageLevel) {
        LanguageLevel languageLevel;

        try {
            languageLevel = languageLevelService.getLanguageLevelByID(idLanguageLevel);
        } catch (DataAccessException e) {
            throw new LanguageLevelException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        return new ResponseEntity<>(languageLevel, HttpStatus.OK);
    }

}
