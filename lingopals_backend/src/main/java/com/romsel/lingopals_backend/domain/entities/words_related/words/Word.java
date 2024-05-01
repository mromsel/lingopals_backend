package com.romsel.lingopals_backend.domain.entities.words_related.words;

import com.romsel.lingopals_backend.domain.entities.words_related.Language;
import com.romsel.lingopals_backend.domain.entities.words_related.WordReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_word", insertable = false)
    private Long idWord;

    @ManyToOne(targetEntity = WordReference.class, optional = false, cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_word_reference", updatable = false)
    private WordReference wordReference;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_language", updatable = false)
    private Language language;

    @Column(name = "word_string")
    private String wordString;

    @Column(name = "definition")
    private String definition;

    @Column(name = "romanization")
    private String romanization;

    @Column(name = "pronunciation")
    private String pronunciation;

    @Column(name = "changes_on_gender")
    private Boolean changesOnGender;

    @Column(name = "changes_on_plural")
    private Boolean changesOnPlural;

    @Column(name = "gramatical_category")
    private String gramaticalCategory; // verb, sustantive, adjective

    @Column(name = "gramatical_gender")
    private String gramaticalGender; // M, F, N

    @Column(name = "gender_variations")
    private String[] genderVariations; // "F actriz", "M actor"

    @Column(name = "number_variations")
    private String[] numberVariations; // "S árbol", "P árboles"

}
