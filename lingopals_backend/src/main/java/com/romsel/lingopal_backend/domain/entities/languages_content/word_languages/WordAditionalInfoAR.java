package com.romsel.lingopal_backend.domain.entities.languages_content.word_languages;

import com.romsel.lingopal_backend.domain.entities.languages_content.WordAditionalInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "words_aditional_info_ar")
public class WordAditionalInfoAR extends WordAditionalInfo {

    @OneToOne(optional = false)
    @JoinColumn(name = "id_word", insertable = false, updatable = false)
    private WordAR word;

}
