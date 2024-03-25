package com.romsel.lingopals_backend.application.rest.words_related;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.application.response.words_related.WordDto;
import com.romsel.lingopals_backend.domain.services.words_related.WordService;

@RestController
@RequestMapping("/api")
public class WordController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WordService wordService;

    @GetMapping("words")
    public List<WordDto> getAllWords() {
        return wordService.getAllWords()
                .stream()
                .map(word -> modelMapper.map(word, WordDto.class))
                .toList();
    }

    @GetMapping("words/{idLanguage}")
    public List<WordDto> getAllWordsByLanguage(@PathVariable int idLanguage) {
        return wordService.getAllWordsByLanguage(idLanguage)
                .stream()
                .map(word -> modelMapper.map(word, WordDto.class))
                .toList();
    }

}
