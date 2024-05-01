package com.romsel.lingopals_backend.application.rest.words_related.words;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.domain.entities.words_related.words.WordFR;
import com.romsel.lingopals_backend.domain.services.words_related.words.WordFRService;

@RestController
@RequestMapping("/api/words/fr")
public class WordFRController extends WordControllerImpl<WordFR, WordFRService> {

}
