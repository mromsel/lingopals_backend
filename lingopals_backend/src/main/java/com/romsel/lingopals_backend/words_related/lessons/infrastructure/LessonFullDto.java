package com.romsel.lingopals_backend.words_related.lessons.infrastructure;

import java.util.List;

import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeDto;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.words_related.semantic_categories.infrastructure.SemanticCategoryFullDto;

import lombok.Data;

@Data
public class LessonFullDto {

    private Integer idLesson;
    private String lessonName;
    private LanguageLevelDto languageLevel;
    private ActivityTypeDto activityType;
    private List<WordsInLessonDto> wordsList;
    private SemanticCategoryFullDto semanticCategory;

}
