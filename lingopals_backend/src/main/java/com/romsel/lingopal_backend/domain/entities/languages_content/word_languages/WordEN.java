package com.romsel.lingopal_backend.domain.entities.languages_content.word_languages;

import com.romsel.lingopal_backend.domain.entities.languages_content.Word;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity(name = "words_en")
public class WordEN extends Word {

    @OneToOne(optional = false, mappedBy = "word")
    private WordAditionalInfoEN aditionalInfo;

}
