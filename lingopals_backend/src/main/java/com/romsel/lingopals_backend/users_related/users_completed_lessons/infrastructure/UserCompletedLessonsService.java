package com.romsel.lingopals_backend.users_related.users_completed_lessons.infrastructure;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;
import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivity;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessons;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessonsException;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessonsRepository;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;
import com.romsel.lingopals_backend.words_related.lessons.domain.LessonException;
import com.romsel.lingopals_backend.words_related.lessons.infrastructure.LessonService;

@Service
public class UserCompletedLessonsService {

    @Autowired
    private UserCompletedLessonsRepository userCompletedLessonsRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private LessonService lessonService;

    public List<UserCompletedLessons> getAllUserCompletedLessons() {
        return (List<UserCompletedLessons>) userCompletedLessonsRepository.findAll();
    }

    public List<UserCompletedLessons> getAllUserLessonsByUserID(Long idUser) {
        return userCompletedLessonsRepository.findByUser(userService.getUserByID(idUser));
    }

    public UserCompletedLessons save(UserActivity userActivity) {
        if (userActivity.getIdLesson() != null && userActivity.getUser() != null) {
            Lesson lesson;
            try {
                lesson = lessonService.getLessonByID(userActivity.getIdLesson());
            } catch (LessonException e) {
                // If lesson doesnt exist or is null
                throw new UserCompletedLessonsException(HttpStatus.NOT_FOUND, e.getCustomErrors());
            }

            UserCompletedLessons existingUserCompletedLessons = this.userCompletedLessonsRepository
                    .findByLessonAndUser(
                            lesson,
                            (userActivity.getUser()));

            if (existingUserCompletedLessons == null) {
                UserCompletedLessons newUserCompletedLessons = new UserCompletedLessons();
                newUserCompletedLessons.setUser(userActivity.getUser());
                newUserCompletedLessons.setLesson(lesson);
                newUserCompletedLessons.setIdUserLanguages(userActivity.getUserLanguages().getIdUserLanguages());
                newUserCompletedLessons
                        .setCompletionDate(ZonedDateTime.now(ZoneId.of(userActivity.getUser().getTimeZone())));
                return this.userCompletedLessonsRepository.save(newUserCompletedLessons);
            }
        }
        return null;
    }
}
