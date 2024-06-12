package com.romsel.lingopals_backend.words_related.lessons.infrastructure.full_getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.words_related.lessons.application.full_getter.LessonFullDto;
import com.romsel.lingopals_backend.words_related.lessons.application.full_getter.LessonFullGetter;

@RestController
@RequestMapping("/api")
public class LessonFullGetterController {

    @Autowired
    private LessonFullGetter lessonFullGetter;

    @GetMapping("/lessons/{idLesson}/{idUserLanguages}")
    public ResponseEntity<LessonFullDto> getLessonByID(@PathVariable Integer idLesson,
            @PathVariable Long idUserLanguages) {
        return new ResponseEntity<>(lessonFullGetter.getFullLesson(idLesson, idUserLanguages), HttpStatus.OK);
    }

}
