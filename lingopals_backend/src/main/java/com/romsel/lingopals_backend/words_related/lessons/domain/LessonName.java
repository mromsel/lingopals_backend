package com.romsel.lingopals_backend.words_related.lessons.domain;

import com.romsel.lingopals_backend.masters.languages.domain.Language;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lessons_names")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLessonName;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_language")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "id_lesson")
    private Lesson lesson;
}
