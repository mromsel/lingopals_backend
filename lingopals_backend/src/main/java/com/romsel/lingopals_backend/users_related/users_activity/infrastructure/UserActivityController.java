package com.romsel.lingopals_backend.users_related.users_activity.infrastructure;

import java.time.ZonedDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.common.Constants;
import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeService;
import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;
import com.romsel.lingopals_backend.users_related.users_activity.domain.ActivityEnum;
import com.romsel.lingopals_backend.users_related.users_activity.domain.ActivityResult;
import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivity;
import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivityException;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.infrastructure.UserCompletedLessonsService;
import com.romsel.lingopals_backend.users_related.users_languages.infrastructure.UserLanguagesService;
import com.romsel.lingopals_backend.users_related.users_progress.domain.level_up.UserLevelManager;
import com.romsel.lingopals_backend.users_related.users_progress.infrastructure.level_up.UserLevelUpdateDto;
import com.romsel.lingopals_backend.users_related.users_review_words.infrastructure.UserReviewWordsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class UserActivityController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserActivityService userActivityService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserLanguagesService userLanguagesService;

    @Autowired
    private UserReviewWordsService userReviewWordsService;

    @Autowired
    private UserCompletedLessonsService userCompletedLessonsService;

    @Autowired
    private ActivityTypeService activityTypeService;

    @Autowired
    private UserLevelManager userLevelManager;

    @GetMapping("/users-activities")
    public List<UserActivityDto> getAllUsersActivities() {
        return userActivityService.getAllUsersActivities()
                .stream()
                .map(userActivity -> modelMapper.map(userActivity, UserActivityDto.class))
                .toList();
    }

    @GetMapping("/users-activities/{idUser}")
    public List<UserActivityDto> getUserActivityByUserID(@PathVariable Long idUser) {
        return userActivityService.getUserActivityByUserID(idUser)
                .stream()
                .map(userActivity -> modelMapper.map(userActivity, UserActivityDto.class))
                .toList();
    }

    @PostMapping("/users-activities")
    public ResponseEntity<?> create(@RequestBody UserActivityDto userActivityDto) {
        UserActivity userActivity = new UserActivity();

        UserLevelUpdateDto userLevelUpdateDto = null;
        try {
            userActivity.setUser(userService.getUserByID(userActivityDto.getIdUser()));
            userActivity.setDate(ZonedDateTime.now());

            userActivity.setUserLanguages(
                    userLanguagesService.getUserLanguagesById(userActivityDto.getUserLanguages().getId()));
            userActivity.setXpGained(Constants.XP_GAINED_PER_ACTIVITY);

            userActivity.setResults(userActivityDto.getResults().stream()
                    .map(resultDto -> modelMapper.map(resultDto, ActivityResult.class)).toList());
            this.userReviewWordsService.saveActivityResults(userActivity);

            userActivity.setActivityType(activityTypeService.findByType(userActivityDto.getActivityType().getType()));

            if (userActivity.getActivityType().getType().equals(ActivityEnum.LESSON.name())) {
                /*
                 * In lesson add the id and
                 * add to completed lessons
                 */
                userActivity.setIdLesson(userActivityDto.getIdLesson());
                this.userCompletedLessonsService.save(userActivity);
            }

            // Add xp
            userLevelUpdateDto = this.userLevelManager.addXP(userActivity.getUser().getIdUser(), 50);
            userActivity.setXpGained(50);

            // Save activity
            this.userActivityService.save(userActivity);

        } catch (Exception e) {
            throw new UserActivityException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        return new ResponseEntity<>(userLevelUpdateDto, HttpStatus.OK);
    }

}
