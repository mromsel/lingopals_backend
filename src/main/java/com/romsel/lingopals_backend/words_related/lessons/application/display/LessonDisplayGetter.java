package com.romsel.lingopals_backend.words_related.lessons.application.display;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.common.Constants;
import com.romsel.lingopals_backend.masters.activity_types.domain.ActivityType;
import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeService;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessons;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.infrastructure.UserCompletedLessonsService;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.users_related.users_languages.infrastructure.UserLanguagesService;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;
import com.romsel.lingopals_backend.words_related.lessons.domain.LessonRepository;
import com.romsel.lingopals_backend.words_related.semantic_categories.application.SemanticCategoryGetter;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonDisplayGetter {

    private final LessonRepository lessonRepository;

    private final UserLanguagesService userLanguagesService;

    private final UserCompletedLessonsService userCompletedLessonsService;

    private final ActivityTypeService activityTypeService;

    private final SemanticCategoryGetter semanticCategoryGetter;

    public List<LessonDisplay> getLessonsByUserLanguagesWithProgress(Long idUserLanguages) {
        ActivityType activityType = activityTypeService.findByType(Constants.ACTIVITY_TYPE_LESSON);
        UserLanguages userLanguages = this.userLanguagesService.getUserLanguagesById(idUserLanguages);
        List<Lesson> lessons = this.lessonRepository.findByLanguageLevel(userLanguages.getLanguageLevel());
        List<UserCompletedLessons> completedLessons = this.userCompletedLessonsService
                .getCompletedLessonsByIdUserLanguagesAndLanguageLevel(idUserLanguages);

        List<LessonDisplay> result = new ArrayList<>();

        lessons.stream().forEach(lesson -> {
            Optional<UserCompletedLessons> userCompletedLessonOptional = completedLessons.stream().filter(
                    completedLesson -> Objects.equals(completedLesson.getLesson().getIdLesson(), lesson.getIdLesson()))
                    .findFirst();
            if (userCompletedLessonOptional.isPresent()) {
                UserCompletedLessons userCompletedLesson = userCompletedLessonOptional.get();
                if (userCompletedLesson.getCompletionDate() != null) {
                    userCompletedLesson.setProgressPercent(1.0);
                    lesson.setUserCompletedLesson(userCompletedLesson);
                    lesson.setIsCompleted(true);
                } else if (userCompletedLesson.getStartDate() != null
                        && userCompletedLesson.getCompletionDate() == null) {
                    lesson.setUserCompletedLesson(userCompletedLesson);
                }
            }
            SemanticCategory semanticCategory = semanticCategoryGetter
                    .getFullCategory(lesson.getSemanticCategory().getIdSemanticCategory(), userLanguages);

            LessonDisplay lessonDisplay = LessonDisplay.builder()
                    .idLesson(lesson.getIdLesson())
                    .lessonName(lesson.getLessonName())
                    .languageLevel(lesson.getLanguageLevel())
                    .activityType(activityType)
                    .isCompleted(lesson.getIsCompleted())
                    .userCompletedLesson(lesson.getUserCompletedLesson())
                    .semanticCategory(semanticCategory)
                    .build();

            result.add(lessonDisplay);
        });
        return result;
    }
}
