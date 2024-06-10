package com.romsel.lingopals_backend.words_related.words.infrastructure;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.words_related.words.domain.Word
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
