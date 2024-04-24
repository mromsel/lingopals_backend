package com.romsel.lingopals_backend.application.response.words_related;

import java.util.List;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.words_related.Lesson
 */
@Data
public class LessonDto {

    private Integer idLesson;
    private String lessonName;
    private LanguageLevelDto languageLevel;
    private List<WordDto> listWordsOrigin;
    private List<WordDto> listWordDestiny;

}
