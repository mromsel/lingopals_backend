package com.romsel.lingopals_backend.application.response;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.languages_content.Word
 */
@Data
public class WordDto {

    private long idWord;
    private WordReferenceDto wordReference;
    private LanguageDto language;
    private String word;
    private String definition;
    private WordAdditionalInfoDto additionalInfo;

}
