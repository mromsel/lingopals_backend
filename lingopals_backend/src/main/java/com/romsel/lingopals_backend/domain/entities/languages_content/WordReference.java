package com.romsel.lingopals_backend.domain.entities.languages_content;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "words_references")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WordReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_word_ref", insertable = false)
    private Long idWordRef;

    @JoinColumn(name = "language_level")
    @ManyToOne(targetEntity = LanguageLevel.class, optional = false, fetch = FetchType.LAZY)
    private LanguageLevel languageLevel;

    @JoinColumn(name = "category")
    @ManyToOne(targetEntity = Category.class, optional = true, fetch = FetchType.LAZY)
    private Category category;

    @ManyToMany(mappedBy = "listWordsReferences")
    private List<Lesson> lessons;

}
