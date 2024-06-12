package com.romsel.lingopals_backend.words_related.lessons.application.full_getter;

import java.util.List;

import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeDto;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;
import com.romsel.lingopals_backend.words_related.lessons.infrastructure.WordsInLessonDto;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategory;
import com.romsel.lingopals_backend.words_related.semantic_categories.infrastructure.SemanticCategoryFullDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LessonFullDto {

    private Integer idLesson;
    private String lessonName;
    private LanguageLevelDto languageLevel;
    private ActivityTypeDto activityType;
    private List<WordsInLessonDto> wordsList;
    private SemanticCategoryFullDto semanticCategory;

    public static LessonFullDto convertToDto(Lesson lesson, List<WordsInLessonDto> wordsList,
            SemanticCategory semanticCategory) {
        return LessonFullDto.builder()
                .idLesson(lesson.getIdLesson())
                .lessonName(lesson.getLessonName())
                .languageLevel(LanguageLevelDto.convertToDto(lesson.getLanguageLevel()))
                .activityType(ActivityTypeDto.convertToDto(lesson.getActivityType()))
                .wordsList(wordsList)
                .semanticCategory(SemanticCategoryFullDto.convertToDto(semanticCategory))
                .build();
    }
}
