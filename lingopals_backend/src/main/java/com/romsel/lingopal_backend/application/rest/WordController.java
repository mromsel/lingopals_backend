package com.romsel.lingopal_backend.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopal_backend.domain.entities.languages_content.Word;
import com.romsel.lingopal_backend.domain.services.WordService;

@RestController
@RequestMapping("/api")
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("words")
    public List<Word> getAllWords() {
        return wordService.getAllWords();
    }

    @GetMapping("words/{idLanguage}")
    public List<Word> getAllWordsByLanguage(@PathVariable int idLanguage) {
        return wordService.getAllWordsByLanguage(idLanguage);
    }

}
