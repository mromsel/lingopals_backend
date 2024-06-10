package com.romsel.lingopals_backend.words_related.lessons.application.display;

import com.romsel.lingopals_backend.masters.activity_types.domain.ActivityType;
import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessons;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LessonDisplay {
    private Integer idLesson;
    private String lessonName;
    private LanguageLevel languageLevel;
    private ActivityType activityType;
    private Boolean isCompleted;
    private UserCompletedLessons userCompletedLesson;
    private SemanticCategory semanticCategory;
}
