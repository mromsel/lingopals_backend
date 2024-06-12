package com.romsel.lingopals_backend.words_related.lessons.infrastructure.display;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeDto;
import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessons;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.infrastructure.UserCompletedLessonsDto;
import com.romsel.lingopals_backend.words_related.lessons.application.display.LessonDisplayGetter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class LessonDisplayController {

    private LessonDisplayGetter lessonDisplayGetter;

    public LessonDisplayController(LessonDisplayGetter lessonDisplayGetter) {
        this.lessonDisplayGetter = lessonDisplayGetter;
    }

    @GetMapping("/lessons/display/{idUserLanguages}")
    public List<LessonDisplayDto> getDisplayLessons(@PathVariable Long idUserLanguages) {
        return lessonDisplayGetter.getLessonsByUserLanguagesWithProgress(idUserLanguages)
                .stream()
                .map(lessonDisplay -> {
                    LessonDisplayDto lessonDisplayDto = new LessonDisplayDto();
                    lessonDisplayDto.setIdLesson(lessonDisplay.getIdLesson());
                    lessonDisplayDto.setLessonName(lessonDisplay.getLessonName());

                    // Mapping from LanguageLevel to LanguageLevelDto
                    LanguageLevelDto languageLevelDto = new LanguageLevelDto();
                    LanguageLevel languageLevel = lessonDisplay.getLanguageLevel();
                    if (languageLevel != null) {
                        languageLevelDto.setIdLevel(languageLevel.getIdLevel());
                        languageLevelDto.setLevelName(languageLevel.getLevelName());
                    }
                    lessonDisplayDto.setLanguageLevel(languageLevelDto);

                    // Mapping from ActivityType to ActivityTypeDto
                    ActivityTypeDto activityTypeDto = ActivityTypeDto.convertToDto(lessonDisplay.getActivityType());

                    lessonDisplayDto.setActivityType(activityTypeDto);

                    lessonDisplayDto.setIsCompleted(lessonDisplay.getIsCompleted());

                    // Mapping from UserCompletedLessons to UserCompletedLessonsDto
                    UserCompletedLessons userCompletedLesson = lessonDisplay.getUserCompletedLesson();
                    if (userCompletedLesson != null) {
                        UserCompletedLessonsDto userCompletedLessonsDto = new UserCompletedLessonsDto();
                        userCompletedLessonsDto
                                .setIdCompletedLesson(userCompletedLesson.getIdCompletedLesson());
                        userCompletedLessonsDto
                                .setIdUserLanguages(
                                        userCompletedLesson.getUserLanguages().getIdUserLanguages());
                        userCompletedLessonsDto.setIdLesson(userCompletedLesson.getLesson().getIdLesson());
                        userCompletedLessonsDto.setStartDate(userCompletedLesson.getStartDate());
                        userCompletedLessonsDto.setCompletionDate(userCompletedLesson.getCompletionDate());
                        userCompletedLessonsDto.setProgressPercent(userCompletedLesson.getProgressPercent());
                        lessonDisplayDto.setUserCompletedLesson(userCompletedLessonsDto);
                    }

                    return lessonDisplayDto;
                })
                .collect(Collectors.toList());
    }
}
