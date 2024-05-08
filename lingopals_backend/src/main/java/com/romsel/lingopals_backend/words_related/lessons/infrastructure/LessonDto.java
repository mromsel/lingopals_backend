package com.romsel.lingopals_backend.words_related.lessons.infrastructure;

import java.util.List;

import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.words_related.words.infrastructure.WordDto;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.words_related.lessons.domain.Lesson
 */
@Data
public class LessonDto {

    private Integer idLesson;
    private String lessonName;
    private LanguageLevelDto languageLevel;
    private List<WordDto> listWordsOrigin;
    private List<WordDto> listWordDestiny;

}
