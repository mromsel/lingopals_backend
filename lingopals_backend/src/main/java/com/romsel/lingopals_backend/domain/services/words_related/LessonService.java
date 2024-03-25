package com.romsel.lingopals_backend.domain.services.words_related;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.application.exceptions.words_related.LessonException;
import com.romsel.lingopals_backend.domain.entities.words_related.Lesson;
import com.romsel.lingopals_backend.domain.repositories.words_related.LessonRepository;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() {
        return (List<Lesson>) lessonRepository.findAll();
    }

    public Lesson getLessonByID(Integer idLesson) {
        return lessonRepository.findById(idLesson).orElseThrow(
                () -> new LessonException(HttpStatus.NOT_FOUND, List.of(ExceptionMessages.LESSON_NOT_FOUND)));
    }

}
