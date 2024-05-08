package com.romsel.lingopals_backend.users_related.users_completed_lessons.infrastructure;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.users_related.users.domain.User;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessons
 */
@Data
public class UserCompletedLessonsDto {

    private Long idCompletedLesson;
    private User user;
    private Lesson lesson;
    private ZonedDateTime completionDate;

}
