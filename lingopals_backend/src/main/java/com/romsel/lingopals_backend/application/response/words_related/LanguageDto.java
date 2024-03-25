package com.romsel.lingopals_backend.application.response.words_related;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.words_related.Language
 */
@Data
public class LanguageDto {

    private Integer idLanguage;
    private String languageName;
    private String isoCode;
    private String flag;
    private WritingSystemDto writingSystem;

}
