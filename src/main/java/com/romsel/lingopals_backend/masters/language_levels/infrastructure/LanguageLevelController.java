package com.romsel.lingopals_backend.masters.language_levels.infrastructure;

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

import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel;
import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevelException;

@RestController
@RequestMapping("/api")
public class LanguageLevelController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageLevelService languageLevelService;

    @GetMapping("language-levels")
    public List<LanguageLevelDto> getAllLanguageLevels() {
        return languageLevelService.getAllLanguageLevels()
                .stream()
                .map(languageLevel -> modelMapper.map(languageLevel, LanguageLevelDto.class))
                .toList();
    }

    @GetMapping("language-levels/{idLanguageLevel}")
    public ResponseEntity<LanguageLevelDto> getLanguageLevelById(@PathVariable int idLanguageLevel) {
        LanguageLevel languageLevel;

        try {
            languageLevel = languageLevelService.getLanguageLevelByID(idLanguageLevel);
        } catch (DataAccessException e) {
            throw new LanguageLevelException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        LanguageLevelDto languageLevelDto = modelMapper.map(languageLevel, LanguageLevelDto.class);

        return new ResponseEntity<>(languageLevelDto, HttpStatus.OK);
    }

}
