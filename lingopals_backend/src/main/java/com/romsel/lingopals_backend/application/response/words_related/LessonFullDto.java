package com.romsel.lingopals_backend.application.response.words_related;

import java.util.List;

import lombok.Data;

@Data
public class LessonFullDto {

    private Integer idLesson;
    private String lessonName;
    private LanguageLevelDto languageLevel;
    private List<WordsInLessonDto> wordsList;

}
