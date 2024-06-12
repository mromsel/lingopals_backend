package com.romsel.lingopals_backend.words_related.lessons.infrastructure;

import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeDto;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.words_related.lessons.domain.Lesson
 */
@Data
public class LessonDto {

    private Integer idLesson;
    private String lessonName;
    private LanguageLevelDto languageLevel;
    private ActivityTypeDto activityType;
    private Boolean isCompleted;
}
