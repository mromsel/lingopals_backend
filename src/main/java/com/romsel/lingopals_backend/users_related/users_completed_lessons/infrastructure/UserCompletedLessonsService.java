package com.romsel.lingopals_backend.users_related.users_completed_lessons.infrastructure;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivity;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessons;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessonsException;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessonsRepository;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.users_related.users_languages.infrastructure.UserLanguagesService;
import com.romsel.lingopals_backend.users_related.users_review_words.domain.UserReviewWords;
import com.romsel.lingopals_backend.users_related.users_review_words.infrastructure.UserReviewWordsService;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;
import com.romsel.lingopals_backend.words_related.lessons.domain.LessonException;
import com.romsel.lingopals_backend.words_related.lessons.infrastructure.LessonService;
import com.romsel.lingopals_backend.words_related.word_references.domain.WordReference;

@Service
public class UserCompletedLessonsService {

    private UserCompletedLessonsRepository userCompletedLessonsRepository;

    private LessonService lessonService;

    private UserLanguagesService userLanguagesService;

    private UserReviewWordsService userReviewWordsService;

    public UserCompletedLessonsService(
            UserCompletedLessonsRepository userCompletedLessonsRepository,
            @Lazy LessonService lessonService,
            UserLanguagesService userLanguagesService,
            UserReviewWordsService userReviewWordsService) {
        this.userCompletedLessonsRepository = userCompletedLessonsRepository;
        this.lessonService = lessonService;
        this.userLanguagesService = userLanguagesService;
        this.userReviewWordsService = userReviewWordsService;
    }

    public List<UserCompletedLessons> getAllUserCompletedLessons() {
        return (List<UserCompletedLessons>) userCompletedLessonsRepository.findAll();
    }

    public List<UserCompletedLessons> getAllUserLessonsByIdUserLanguages(Long idUserLanguages) {
        return userCompletedLessonsRepository
                .findByUserLanguages(userLanguagesService.getUserLanguagesById(idUserLanguages));
    }

    public List<UserCompletedLessons> getCompletedLessonsByIdUserLanguagesAndLanguageLevel(Long idUserLanguages) {
        UserLanguages userLanguages = this.userLanguagesService.getUserLanguagesById(idUserLanguages);
        return userCompletedLessonsRepository
                .findAllByLanguageLevelAndUserLanguages(userLanguages.getLanguageLevel().getIdLevel(), idUserLanguages);
    }

    public UserCompletedLessons save(UserActivity userActivity) {
        if (userActivity.getIdLesson() != null && userActivity.getUserLanguages() != null) {
            Lesson lesson;
            try {
                lesson = lessonService.getLessonByID(userActivity.getIdLesson());
            } catch (LessonException e) {
                // If lesson doesnt exist or is null
                throw new UserCompletedLessonsException(HttpStatus.NOT_FOUND, e.getCustomErrors());
            }
            UserCompletedLessons existingUserCompletedLessons = this.userCompletedLessonsRepository
                    .findByLessonAndUserLanguages(
                            lesson,
                            (userActivity.getUserLanguages()));

            UserCompletedLessons newUserCompletedLessons = new UserCompletedLessons();
            if (existingUserCompletedLessons == null) {
                newUserCompletedLessons.setStartDate(
                        ZonedDateTime.now(ZoneId.of(userActivity.getUserLanguages().getUser().getTimeZone())));
                newUserCompletedLessons.setLesson(lesson);
                newUserCompletedLessons.setUserLanguages(userActivity.getUserLanguages());
            } else {
                newUserCompletedLessons = existingUserCompletedLessons;
            }

            newUserCompletedLessons.setProgressPercent(getLessonProgress(lesson, userActivity.getUserLanguages()));

            if (newUserCompletedLessons.getProgressPercent() == 1.0) {
                newUserCompletedLessons.setCompletionDate(
                        ZonedDateTime.now(ZoneId.of(userActivity.getUserLanguages().getUser().getTimeZone())));
            }
            return this.userCompletedLessonsRepository.save(newUserCompletedLessons);
        }
        return null;
    }

    private double getLessonProgress(Lesson lesson, UserLanguages userLanguages) {
        List<WordReference> listWordReferences = lesson.getListWordsReferences();

        List<UserReviewWords> listReviewWords = this.userReviewWordsService.findByIdUserLanguagesAndIdWordReferenceIn(
                userLanguages.getIdUserLanguages(),
                listWordReferences
                        .stream()
                        .map(WordReference::getIdWordRef)
                        .toList());

        double progress = 0;

        if (!listReviewWords.isEmpty()) {
            progress = (double) listReviewWords.size() / listWordReferences.size();
        }

        return progress;
    }
}
