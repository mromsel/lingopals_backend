package com.romsel.lingopals_backend.users_related.users_completed_lessons.infrastructure;

import java.time.ZonedDateTime;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessons
 */
@Data
public class UserCompletedLessonsDto {

    private Long idCompletedLesson;
    private Long idUserLanguages;
    private Integer idLesson;
    private ZonedDateTime startDate;
    private ZonedDateTime completionDate;
    private Double progressPercent;

}
