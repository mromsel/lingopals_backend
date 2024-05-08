package com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.words_related.words.domain.words_languages.entities.WordKO;
import com.romsel.lingopals_backend.words_related.words.infrastructure.WordControllerImpl;
import com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.services.WordKOService;

@RestController
@RequestMapping("/api/words/ko")
public class WordKOController extends WordControllerImpl<WordKO, WordKOService> {

}
