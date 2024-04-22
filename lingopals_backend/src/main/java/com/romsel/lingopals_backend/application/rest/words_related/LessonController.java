package com.romsel.lingopals_backend.application.rest.words_related;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.application.exceptions.words_related.LessonException;
import com.romsel.lingopals_backend.application.response.words_related.LessonDto;
import com.romsel.lingopals_backend.application.response.words_related.WordDto;
import com.romsel.lingopals_backend.domain.entities.words_related.Lesson;
import com.romsel.lingopals_backend.domain.entities.words_related.WordReference;
import com.romsel.lingopals_backend.domain.services.words_related.LessonService;
import com.romsel.lingopals_backend.domain.services.words_related.WordService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class LessonController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private WordService wordService;

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

        List<Long> idsWordReferences = lesson.getListWordsReferences().stream().map(WordReference::getIdWordRef)
                .toList();
        List<WordDto> wordsOrigin = wordService.getWordsByWordReferencesAndLanguage(idsWordReferences, 1).stream()
                .map(word -> modelMapper.map(word, WordDto.class)).toList();

        List<WordDto> wordsDestiny = wordService.getWordsByWordReferencesAndLanguage(idsWordReferences, 2).stream()
                .map(word -> modelMapper.map(word, WordDto.class)).toList();

        lessonDto.setListWordsOrigin(wordsOrigin);
        lessonDto.setListWordDestiny(wordsDestiny);
        return new ResponseEntity<>(lessonDto, HttpStatus.OK);
    }

}
