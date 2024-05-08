package com.romsel.lingopals_backend.words_related.lessons.infrastructure;

import java.util.List;

import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;

import lombok.Data;

@Data
public class LessonFullDto {

    private Integer idLesson;
    private String lessonName;
    private LanguageLevelDto languageLevel;
    private List<WordsInLessonDto> wordsList;

}
