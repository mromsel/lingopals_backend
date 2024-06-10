package com.romsel.lingopals_backend.words_related.lessons.infrastructure.display;

import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeDto;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.infrastructure.UserCompletedLessonsDto;
import com.romsel.lingopals_backend.words_related.semantic_categories.infrastructure.SemanticCategoryFullDto;

import lombok.Data;

@Data
public class LessonDisplayDto {

    private Integer idLesson;
    private String lessonName;
    private LanguageLevelDto languageLevel;
    private ActivityTypeDto activityType;
    private Boolean isCompleted;
    private UserCompletedLessonsDto userCompletedLesson;
    private SemanticCategoryFullDto semanticCategory;
}
