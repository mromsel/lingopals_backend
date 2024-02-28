package com.romsel.lingopal_backend.domain.entities.languages_content;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "words")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_word", insertable = false)
    private Long idWord;

    @ManyToOne(targetEntity = WordReference.class, optional = false, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_word_reference", updatable = false)
    private WordReference wordReference;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_language", updatable = false)
    private Language language;

    @Column(name = "word")
    private String word;

    @Column(name = "definition")
    private String definition;

    @OneToOne(targetEntity = WordAdditionalInfo.class, mappedBy = "word", fetch = FetchType.LAZY)
    private WordAdditionalInfo additionalInfo;
}
