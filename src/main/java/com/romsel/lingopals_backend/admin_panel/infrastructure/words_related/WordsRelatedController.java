package com.romsel.lingopals_backend.admin_panel.infrastructure.words_related;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class WordsRelatedController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WordsRelatedService wordsRelatedService;

    @GetMapping("/admin-panel/words-related")
    public WordsRelatedDto getWordsRelated() {
        return modelMapper.map(wordsRelatedService.getWordsRelated(), WordsRelatedDto.class);
    }

}
