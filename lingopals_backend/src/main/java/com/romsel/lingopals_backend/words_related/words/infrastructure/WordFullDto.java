package com.romsel.lingopals_backend.words_related.words.infrastructure;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.words_related.words.domain.Word
 */
@Data
public class WordFullDto implements Comparable<WordFullDto> {

    private WordDto wordDto;
    private String romanization;
    private String pronunciation;
    private Boolean changesOnGender;
    private Boolean changesOnPlural;
    private String gramaticalCategory; // verb, sustantive, adjective
    private String gramaticalGender; // M, F, N
    private String[] genderVariations; // "F actriz", "M actor"
    private String[] numberVariations;

    @Override
    public int compareTo(WordFullDto o) {
        return this.wordDto.getWordString().compareTo(o.getWordDto().getWordString());
    }
}
