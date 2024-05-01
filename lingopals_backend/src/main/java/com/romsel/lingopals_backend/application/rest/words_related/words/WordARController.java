package com.romsel.lingopals_backend.application.rest.words_related.words;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.domain.entities.words_related.words.WordAR;
import com.romsel.lingopals_backend.domain.services.words_related.words.WordARService;

@RestController
@RequestMapping("/api/words/ar")
public class WordARController extends WordControllerImpl<WordAR, WordARService> {

}
