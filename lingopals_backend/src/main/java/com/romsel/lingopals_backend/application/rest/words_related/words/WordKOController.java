package com.romsel.lingopals_backend.application.rest.words_related.words;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.domain.entities.words_related.words.WordKO;
import com.romsel.lingopals_backend.domain.services.words_related.words.WordKOService;

@RestController
@RequestMapping("/api/words/ko")
public class WordKOController extends WordControllerImpl<WordKO, WordKOService> {

}
