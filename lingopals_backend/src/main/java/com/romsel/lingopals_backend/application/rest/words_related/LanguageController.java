package com.romsel.lingopals_backend.application.rest.words_related;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.application.exceptions.words_related.LanguageException;
import com.romsel.lingopals_backend.application.response.words_related.LanguageDto;
import com.romsel.lingopals_backend.domain.entities.words_related.Language;
import com.romsel.lingopals_backend.domain.services.words_related.LanguageService;

@RestController
@RequestMapping("/api")
public class LanguageController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageService languageService;

    @GetMapping("languages")
    public List<LanguageDto> getAllLanguages() {
        return languageService.getAllLanguages()
                .stream()
                .map(language -> modelMapper.map(language, LanguageDto.class))
                .toList();
    }

    @GetMapping("languages/{idLanguage}")
    public ResponseEntity<LanguageDto> getLanguageById(@PathVariable Integer idLanguage) {
        Language language;

        try {
            language = languageService.getLanguageByID(idLanguage);
        } catch (DataAccessException e) {
            throw new LanguageException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        LanguageDto languageDto = modelMapper.map(language, LanguageDto.class);

        return new ResponseEntity<>(languageDto, HttpStatus.OK);
    }

}
