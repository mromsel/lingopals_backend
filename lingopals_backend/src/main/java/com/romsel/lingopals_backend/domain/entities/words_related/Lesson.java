package com.romsel.lingopals_backend.domain.entities.words_related;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "lessons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lesson {

    @Id
    @Column(name = "id_lesson")
    private Integer idLesson;

    @Column(name = "lessonName")
    private String lessonName;

    @JoinColumn(name = "language_level")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LanguageLevel languageLevel;

    @JoinTable(name = "lessons_wordsref", joinColumns = @JoinColumn(name = "id_lesson"), inverseJoinColumns = @JoinColumn(name = "id_ref"))
    @ManyToMany
    private List<WordReference> listWordsReferences;
}
