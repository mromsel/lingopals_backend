package com.romsel.lingopals_backend.application.rest.words_related.words;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.domain.entities.words_related.words.WordES;
import com.romsel.lingopals_backend.domain.services.words_related.words.WordESService;

@RestController
@RequestMapping("/api/words/es")
public class WordESController extends WordControllerImpl<WordES, WordESService> {

}
