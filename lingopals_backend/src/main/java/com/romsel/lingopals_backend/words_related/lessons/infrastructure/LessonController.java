package com.romsel.lingopals_backend.words_related.lessons.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeDto;
import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeService;
import com.romsel.lingopals_backend.masters.languages.domain.LanguageException;
import com.romsel.lingopals_backend.users_related.users_activity.domain.ActivityEnum;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;
import com.romsel.lingopals_backend.words_related.lessons.domain.LessonException;
import com.romsel.lingopals_backend.words_related.word_references.domain.WordReference;
import com.romsel.lingopals_backend.words_related.words.application.WordService;
import com.romsel.lingopals_backend.words_related.words.application.WordServiceFactory;
import com.romsel.lingopals_backend.words_related.words.domain.Word;
import com.romsel.lingopals_backend.words_related.words.infrastructure.WordDto;

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
        private ActivityTypeService activityTypeService;

        @Autowired
        private WordServiceFactory wordServiceFactory;

        @GetMapping("/lessons")
        public List<LessonDto> getAllLessons() {
                return lessonService.getAllLessons()
                                .stream()
                                .map(lesson -> modelMapper.map(lesson, LessonDto.class))
                                .toList();
        }

        @SuppressWarnings("unchecked")
        @GetMapping("/lessons/{idLesson}/{isoLangOrigin}/{isoLangTarget}")
        public ResponseEntity<LessonFullDto> getLessonByID(@PathVariable int idLesson,
                        @PathVariable String isoLangOrigin, @PathVariable String isoLangTarget) {
                Lesson lesson;

                try {
                        lesson = lessonService.getLessonByID(idLesson);
                } catch (DataAccessException e) {
                        throw new LessonException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
                }

                LessonFullDto lessonFullDto = modelMapper.map(lesson, LessonFullDto.class);

                WordService<Word, Long> wordServiceOrigin;
                WordService<Word, Long> wordServiceTarget;
                try {
                        wordServiceOrigin = wordServiceFactory
                                        .getWordServiceByIsoCode(isoLangOrigin);
                        wordServiceTarget = wordServiceFactory
                                        .getWordServiceByIsoCode(isoLangTarget);
                } catch (IllegalArgumentException e) {
                        throw new LanguageException(HttpStatus.NOT_FOUND,
                                        List.of(ExceptionMessages.LANGUAGE_NOT_FOUND));
                }

                List<Long> idsWordReferences = lesson.getListWordsReferences().stream().map(WordReference::getIdWordRef)
                                .toList();
                List<WordDto> wordsOrigin = wordServiceOrigin.findByWordReferenceIn(idsWordReferences)
                                .stream()
                                .map(word -> modelMapper.map(word, WordDto.class)).toList();

                List<WordDto> wordsDestiny = wordServiceTarget.findByWordReferenceIn(idsWordReferences)
                                .stream()
                                .map(word -> modelMapper.map(word, WordDto.class)).toList();

                List<WordsInLessonDto> list = idsWordReferences.stream()
                                .map(idWordReference -> {

                                        WordsInLessonDto newWordsInLessonDto = new WordsInLessonDto();
                                        newWordsInLessonDto.setWordOrigin(
                                                        wordsOrigin.stream()
                                                                        .filter(word -> word.getIdWordRef()
                                                                                        .equals(idWordReference))
                                                                        .findFirst()
                                                                        .orElse(null));
                                        newWordsInLessonDto.setWordTarget(
                                                        wordsDestiny.stream()
                                                                        .filter(word -> word.getIdWordRef()
                                                                                        .equals(idWordReference))
                                                                        .findFirst()
                                                                        .orElse(null));

                                        return newWordsInLessonDto;
                                })
                                .toList();
                lessonFullDto.setWordsList(list);
                lessonFullDto.setActivityType(modelMapper.map(
                                activityTypeService.findByType(ActivityEnum.LESSON.name()), ActivityTypeDto.class));

                return new ResponseEntity<>(lessonFullDto, HttpStatus.OK);
        }

}
