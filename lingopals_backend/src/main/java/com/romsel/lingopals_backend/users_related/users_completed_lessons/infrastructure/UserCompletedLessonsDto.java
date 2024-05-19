package com.romsel.lingopals_backend.users_related.users_completed_lessons.infrastructure;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.users_related.users.infrastructure.UserBasicDto;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessons
 */
@Data
public class UserCompletedLessonsDto {

    private Long idCompletedLesson;
    private UserBasicDto user;
    private Long idUserLanguages;
    private Lesson lesson;
    private ZonedDateTime completionDate;

}
