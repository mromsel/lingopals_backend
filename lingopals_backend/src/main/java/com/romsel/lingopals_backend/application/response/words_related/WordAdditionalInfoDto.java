package com.romsel.lingopals_backend.application.response.words_related;

import java.util.List;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.words_related.WordAdditionalInfo
 */
@Data
public class WordAdditionalInfoDto {

    private Long idWordAdditionalInfo;
    private String romanization;
    private String pronunciation;
    private String gramaticalCategory;
    private String gramaticalGender;
    private List<String> genderVariations;
    private List<String> numberVariations;
    private Boolean changesOnGender;
    private Boolean changesOnPlural;
    private WordDto word;

}
