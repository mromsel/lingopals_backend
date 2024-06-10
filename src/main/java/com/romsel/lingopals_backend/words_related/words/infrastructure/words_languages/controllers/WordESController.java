package com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.words_related.words.domain.words_languages.entities.WordES;
import com.romsel.lingopals_backend.words_related.words.infrastructure.WordControllerImpl;
import com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.services.WordESService;

@RestController
@RequestMapping("/api/words/es")
public class WordESController extends WordControllerImpl<WordES, WordESService> {

}
