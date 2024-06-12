package com.romsel.lingopals_backend.words_related.lessons.application.full_getter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.common.Constants;
import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeService;
import com.romsel.lingopals_backend.masters.languages.domain.LanguageException;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.users_related.users_languages.infrastructure.UserLanguagesService;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;
import com.romsel.lingopals_backend.words_related.lessons.domain.LessonException;
import com.romsel.lingopals_backend.words_related.lessons.infrastructure.LessonService;
import com.romsel.lingopals_backend.words_related.lessons.infrastructure.WordsInLessonDto;
import com.romsel.lingopals_backend.words_related.semantic_categories.application.SemanticCategoryGetter;
import com.romsel.lingopals_backend.words_related.word_references.domain.WordReference;
import com.romsel.lingopals_backend.words_related.words.application.WordService;
import com.romsel.lingopals_backend.words_related.words.application.WordServiceFactory;
import com.romsel.lingopals_backend.words_related.words.domain.Word;
import com.romsel.lingopals_backend.words_related.words.infrastructure.WordDto;

@Service
public class LessonFullGetter {

    @Autowired
    private WordServiceFactory wordServiceFactory;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private ActivityTypeService activityTypeService;

    @Autowired
    private SemanticCategoryGetter semanticCategoryGetter;

    @Autowired
    private UserLanguagesService userLanguagesService;

    @SuppressWarnings("unchecked")
    public LessonFullDto getFullLesson(Integer idLesson, Long idUserLanguages) {
        Lesson lesson;

        try {
            lesson = lessonService.getLessonByID(idLesson);
        } catch (LessonException lessonException) {
            throw lessonException;
        } catch (DataAccessException e) {
            throw new LessonException(HttpStatus.INTERNAL_SERVER_ERROR,
                    List.of(e.getMessage()));
        }
        lesson.setActivityType(activityTypeService.findByType(Constants.ACTIVITY_TYPE_LESSON));

        UserLanguages userLanguages = userLanguagesService.getUserLanguagesById(idUserLanguages);

        WordService<Word, Long> wordServiceOrigin;
        WordService<Word, Long> wordServiceTarget;
        try {
            wordServiceOrigin = wordServiceFactory
                    .getWordServiceByIsoCode(userLanguages.getLanguageOrigin().getIsoCode());
            wordServiceTarget = wordServiceFactory
                    .getWordServiceByIsoCode(userLanguages.getLanguageTarget().getIsoCode());
        } catch (IllegalArgumentException e) {
            throw new LanguageException(HttpStatus.NOT_FOUND,
                    List.of(ExceptionMessages.LANGUAGE_NOT_FOUND));
        }

        List<Long> idsWordReferences = lesson.getListWordsReferences().stream().map(WordReference::getIdWordRef)
                .toList();
        List<WordDto> wordsOrigin = wordServiceOrigin.findByWordReferenceIn(idsWordReferences)
                .stream()
                .map(WordDto::convertToDto)
                .toList();

        List<WordDto> wordsDestiny = wordServiceTarget.findByWordReferenceIn(idsWordReferences)
                .stream()
                .map(WordDto::convertToDto)
                .toList();

        List<WordsInLessonDto> list = idsWordReferences.stream()
                .map(idWordReference -> {

                    WordDto wordOriginDto = wordsOrigin.stream()
                            .filter(word -> word.getIdWordRef()
                                    .equals(idWordReference))
                            .findFirst()
                            .orElse(null);

                    WordDto wordTargetDto = wordsDestiny.stream()
                            .filter(word -> word.getIdWordRef()
                                    .equals(idWordReference))
                            .findFirst()
                            .orElse(null);

                    return WordsInLessonDto.convertToDto(wordOriginDto, wordTargetDto);
                })
                .toList();

        return LessonFullDto.convertToDto(lesson, list,
                semanticCategoryGetter.getFullCategory(lesson.getSemanticCategory().getIdSemanticCategory(),
                        userLanguages));
    }

}