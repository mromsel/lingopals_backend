package com.romsel.lingopals_backend.users_related.users_completed_lessons.domain;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_completed_lessons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCompletedLessons {

    @Id
    @GeneratedValue
    @Column(name = "id_user_completed_lesson")
    private Long idCompletedLesson;

    @ManyToOne
    @JoinColumn(name = "id_user_languages", nullable = false)
    private UserLanguages userLanguages;

    @ManyToOne
    @JoinColumn(name = "id_lesson", nullable = false)
    private Lesson lesson;

    @Column(name = "start_date", nullable = false)
    private ZonedDateTime startDate;

    @Column(name = "completion_date")
    private ZonedDateTime completionDate;

    @Column(name = "progress_percent")
    private Double progressPercent;

}
