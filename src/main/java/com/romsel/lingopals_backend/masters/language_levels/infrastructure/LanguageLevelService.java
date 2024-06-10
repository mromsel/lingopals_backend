package com.romsel.lingopals_backend.masters.language_levels.infrastructure;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel;
import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevelException;
import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevelRepository;

@Service
public class LanguageLevelService {

    @Autowired
    private LanguageLevelRepository languageLevelRepository;

    public List<LanguageLevel> getAllLanguageLevels() {
        return (List<LanguageLevel>) languageLevelRepository.findAll();
    }

    public LanguageLevel getLanguageLevelByID(Integer idLanguageLevel) {
        return languageLevelRepository.findById(idLanguageLevel)
                .orElseThrow(() -> new LanguageLevelException(HttpStatus.NOT_FOUND,
                        List.of(ExceptionMessages.LANGUAGE_LEVEL_NOT_FOUND)));
    }

}
