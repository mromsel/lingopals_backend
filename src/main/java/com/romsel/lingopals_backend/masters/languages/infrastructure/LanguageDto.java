package com.romsel.lingopals_backend.masters.languages.infrastructure;

import com.romsel.lingopals_backend.images.infrastructure.ImageDto;
import com.romsel.lingopals_backend.masters.writing_systems.infrastructure.WritingSystemDto;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.masters.languages.domain.Language
 */
@Data
public class LanguageDto {

    private Integer idLanguage;
    private String languageName;
    private String isoCode;
    private ImageDto flag;
    private WritingSystemDto writingSystem;

}
