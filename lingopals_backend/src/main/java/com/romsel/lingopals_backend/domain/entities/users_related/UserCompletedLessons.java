package com.romsel.lingopals_backend.domain.entities.users_related;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.domain.entities.words_related.Lesson;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_completed_lesson")
    private Long idCompletedLesson;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_lesson", nullable = false)
    private Lesson lesson;

    @Column(name = "completion_date", nullable = false)
    private ZonedDateTime completionDate;

}
