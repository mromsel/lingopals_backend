package com.romsel.lingopal_backend.application.rest;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopal_backend.application.exceptions.LessonException;
import com.romsel.lingopal_backend.application.response.LessonDto;
import com.romsel.lingopal_backend.domain.entities.languages_content.Lesson;
import com.romsel.lingopal_backend.domain.services.LessonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class LessonController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LessonService lessonService;

    @GetMapping("/lessons")
    public List<LessonDto> getAllLessons() {
        return lessonService.getAllLessons()
                .stream()
                .map(lesson -> modelMapper.map(lesson, LessonDto.class))
                .toList();
    }

    @GetMapping("/lessons/{idLesson}")
    public ResponseEntity<LessonDto> getLessonByID(@PathVariable int idLesson) {
        Lesson lesson;

        try {
            lesson = lessonService.getLessonByID(idLesson);
        } catch (DataAccessException e) {
            throw new LessonException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        LessonDto lessonDto = modelMapper.map(lesson, LessonDto.class);

        return new ResponseEntity<>(lessonDto, HttpStatus.OK);
    }

}
