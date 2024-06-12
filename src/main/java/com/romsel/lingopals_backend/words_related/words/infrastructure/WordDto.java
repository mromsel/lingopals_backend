package com.romsel.lingopals_backend.words_related.words.infrastructure;

import com.romsel.lingopals_backend.words_related.words.domain.Word;

import lombok.Builder;
import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.words_related.words.domain.Word
 */
@Data
@Builder
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

    public static WordDto convertToDto(Word word) {
        if (word != null) {
            return WordDto.builder()
                    .idWord(word.getIdWord())
                    .idWordRef(word.getWordReference().getIdWordRef())
                    .idLanguage(word.getLanguage().getIdLanguage())
                    .wordString(word.getWordString())
                    .definition(word.getDefinition())
                    .build();
        } else {
            return null;
        }
    }

}
