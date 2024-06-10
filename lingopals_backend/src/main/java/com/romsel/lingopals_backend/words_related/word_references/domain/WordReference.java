package com.romsel.lingopals_backend.words_related.word_references.domain;

import java.util.List;

import com.romsel.lingopals_backend.images.domain.Image;
import com.romsel.lingopals_backend.masters.grammatical_categories.domain.GrammaticalCategory;
import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue
    @Column(name = "id_word_ref", insertable = false)
    private Long idWordRef;

    @Column(name = "english_word")
    private String englishWord;

    @Column(name = "english_definition")
    private String englishDefinition;

    @JoinColumn(name = "grammatical_category")
    @ManyToOne(targetEntity = GrammaticalCategory.class, optional = false, fetch = FetchType.LAZY)
    private GrammaticalCategory grammaticalCategory;

    @JoinColumn(name = "language_level")
    @ManyToOne(targetEntity = LanguageLevel.class, optional = false, fetch = FetchType.LAZY)
    private LanguageLevel languageLevel;

    @JoinColumn(name = "semantic_category")
    @ManyToOne(targetEntity = SemanticCategory.class, optional = true, fetch = FetchType.LAZY)
    private SemanticCategory semanticCategory;

    @JoinColumn(name = "id_image")
    @ManyToOne(targetEntity = Image.class, optional = true, fetch = FetchType.LAZY)
    private Image image;

    @ManyToMany(mappedBy = "listWordsReferences")
    private List<Lesson> lessons;

}
