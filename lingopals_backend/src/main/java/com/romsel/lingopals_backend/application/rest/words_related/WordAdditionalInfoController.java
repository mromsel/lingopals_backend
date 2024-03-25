package com.romsel.lingopals_backend.application.rest.words_related;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.application.response.words_related.WordAdditionalInfoDto;
import com.romsel.lingopals_backend.domain.entities.words_related.WordAdditionalInfo;
import com.romsel.lingopals_backend.domain.services.words_related.WordAdditionalInfoService;
import com.romsel.lingopals_backend.domain.services.words_related.WordService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class WordAdditionalInfoController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WordAdditionalInfoService wordAdditionalInfoService;

    @Autowired
    private WordService wordService;

    @GetMapping("/words-additional-info/{idWord}")
    public WordAdditionalInfoDto getWordAdditionalInfoByWord(@PathVariable long idWord) {
        WordAdditionalInfo wordAdditionalInfo = wordAdditionalInfoService
                .getWordAdditionalInfoByWord(wordService.getWordById(idWord));
        return modelMapper.map(wordAdditionalInfo, WordAdditionalInfoDto.class);
    }

}
