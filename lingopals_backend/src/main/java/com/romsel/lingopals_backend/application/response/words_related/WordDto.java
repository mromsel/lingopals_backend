package com.romsel.lingopals_backend.application.response.words_related;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.words_related.words.Word
 */
@Data
public class WordDto implements Comparable<WordDto> {

    private Long idWord;
    private Long idWordRef;
    private Integer idLanguage;
    private String wordString;
    private String definition;

    @Override
    public int compareTo(WordDto o) {
        return this.wordString.compareTo(o.wordString);
    }

}
