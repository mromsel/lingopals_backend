package com.romsel.lingopal_backend.domain.entities.languages_content.word_languages;

import com.romsel.lingopal_backend.domain.entities.languages_content.Word;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity(name = "words_es")
public class WordES extends Word {
    
    @OneToOne(optional = false, mappedBy = "word")
    private WordAdditionalInfoES additionalInfo;

}
