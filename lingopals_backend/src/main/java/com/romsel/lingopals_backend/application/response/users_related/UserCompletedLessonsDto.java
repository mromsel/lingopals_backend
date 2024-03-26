package com.romsel.lingopals_backend.application.response.users_related;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.domain.entities.users_related.User;
import com.romsel.lingopals_backend.domain.entities.words_related.Lesson;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.users_related.UserCompletedLessons
 */
@Data
public class UserCompletedLessonsDto {

    private Long idCompletedLesson;
    private User user;
    private Lesson lesson;
    private ZonedDateTime completionDate;

}
