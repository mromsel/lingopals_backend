package com.romsel.lingopals_backend.application.response.words_related;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.words_related.Word
 */
@Data
public class WordDto implements Comparable<WordDto> {

    private Long idWord;
    private Long idWordRef;
    private Integer idLanguage;
    private String word;
    private String definition;
    private WordAdditionalInfoDto additionalInfo;

    @Override
    public int compareTo(WordDto o) {
        return this.word.compareTo(o.word);
    }

}
