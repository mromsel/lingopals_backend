package com.romsel.lingopals_backend.words_related.words.domain.words_languages.entities;

import com.romsel.lingopals_backend.words_related.words.domain.Word;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "words_fr")
public class WordFR extends Word {

}
