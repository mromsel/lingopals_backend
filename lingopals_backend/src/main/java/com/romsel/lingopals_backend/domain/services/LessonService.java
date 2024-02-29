package com.romsel.lingopals_backend.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.application.exceptions.LessonException;
import com.romsel.lingopals_backend.domain.entities.languages_content.Lesson;
import com.romsel.lingopals_backend.domain.repositories.LessonRepository;

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
