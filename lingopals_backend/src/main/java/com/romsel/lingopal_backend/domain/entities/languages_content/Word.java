package com.romsel.lingopal_backend.domain.entities.languages_content;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
    @Column(name = "id_word")
    private Long idWord;

    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "word_reference")
    private WordReference wordReference;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_language", insertable = false, updatable = false)
    private Language language;

    @Column(name = "word")
    private String word;

    @Column(name = "definition")
    private String definition;

}
