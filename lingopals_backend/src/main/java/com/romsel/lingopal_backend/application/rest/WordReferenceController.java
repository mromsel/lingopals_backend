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

import com.romsel.lingopal_backend.application.exceptions.WordReferenceException;
import com.romsel.lingopal_backend.domain.entities.languages_content.WordReference;
import com.romsel.lingopal_backend.domain.services.WordReferenceService;

@RestController
@RequestMapping("/api")
public class WordReferenceController {

    @Autowired
    private WordReferenceService wordReferenceService;

    @GetMapping("word-references")
    public List<WordReference> getAllWordReferences() {
        return wordReferenceService.getAllWordReferences();
    }

    @GetMapping("word-references/{idWordReference}")
    public ResponseEntity<WordReference> getWordReferenceByID(@PathVariable Integer idWordReference) {
        WordReference wordReference;

        try {
            wordReference = wordReferenceService.getWordReferenceByID(idWordReference);
        } catch (DataAccessException e) {
            throw new WordReferenceException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        return new ResponseEntity<>(wordReference, HttpStatus.OK);
    }

}
