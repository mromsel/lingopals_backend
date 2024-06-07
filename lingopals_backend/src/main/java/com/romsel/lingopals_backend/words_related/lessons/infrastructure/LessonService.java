package com.romsel.lingopals_backend.words_related.lessons.infrastructure;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelService;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.infrastructure.UserCompletedLessonsService;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;
import com.romsel.lingopals_backend.words_related.lessons.domain.LessonException;
import com.romsel.lingopals_backend.words_related.lessons.domain.LessonRepository;

@Service
public class LessonService {

    private LessonRepository lessonRepository;

    private UserCompletedLessonsService userCompletedLessonsService;

    private LanguageLevelService languageLevelService;

    public LessonService(LessonRepository lessonRepository,
            @Lazy UserCompletedLessonsService userCompletedLessonsService,
            LanguageLevelService languageLevelService) {
        this.lessonRepository = lessonRepository;
        this.userCompletedLessonsService = userCompletedLessonsService;
        this.languageLevelService = languageLevelService;
    }

    public List<Lesson> getAllLessons() {
        return (List<Lesson>) lessonRepository.findAll();
    }

    public Lesson getLessonByID(Integer idLesson) {
        return lessonRepository.findById(idLesson).orElseThrow(
                () -> new LessonException(HttpStatus.NOT_FOUND, List.of(ExceptionMessages.LESSON_NOT_FOUND)));
    }
}
