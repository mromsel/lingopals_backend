package com.romsel.lingopal_backend.application.response;

import java.util.List;

import lombok.Data;

/**
 * @see com.romsel.lingopal_backend.domain.entities.languages_content.Lesson
 */
@Data
public class LessonDto {

    private Integer idLesson;
    private LanguageLevelDto languageLevel;
    private List<WordReferenceDto> listWordsReferences;

}
