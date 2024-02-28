package com.romsel.lingopal_backend.application.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopal_backend.application.response.WordAdditionalInfoDto;
import com.romsel.lingopal_backend.domain.entities.languages_content.WordAdditionalInfo;
import com.romsel.lingopal_backend.domain.services.WordAdditionalInfoService;
import com.romsel.lingopal_backend.domain.services.WordService;

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
