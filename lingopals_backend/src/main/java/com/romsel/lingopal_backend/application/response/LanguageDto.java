package com.romsel.lingopal_backend.application.response;

import lombok.Data;

/**
 * @see com.romsel.lingopal_backend.domain.entities.languages_content.Language
 */
@Data
public class LanguageDto {

    private Integer idLanguage;
    private String languageName;
    private String isoCode;
    private String flag;
    private WritingSystemDto writingSystem;

}
