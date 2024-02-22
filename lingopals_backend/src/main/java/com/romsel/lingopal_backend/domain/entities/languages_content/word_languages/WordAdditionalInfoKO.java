package com.romsel.lingopal_backend.domain.entities.languages_content.word_languages;

import com.romsel.lingopal_backend.domain.entities.languages_content.WordAdditionalInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "words_additional_info_ko")
public class WordAdditionalInfoKO extends WordAdditionalInfo {

    @OneToOne(optional = false)
    @JoinColumn(name = "id_word", insertable = false, updatable = false)
    private WordKO word;

}
