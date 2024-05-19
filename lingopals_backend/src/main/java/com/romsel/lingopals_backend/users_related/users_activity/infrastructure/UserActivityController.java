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
import com.romsel.lingopals_backend.masters.activity_types.domain.ActivityType;
import com.romsel.lingopals_backend.masters.activity_types.domain.ActivityTypeException;
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
    public ResponseEntity<UserLevelUpdateDto> create(@RequestBody UserActivityDto userActivityDto) {
        UserActivity userActivity = new UserActivity();

        UserLevelUpdateDto userLevelUpdateDto = null;
        try {
            userActivity.setUser(userService.getUserByID(userActivityDto.getIdUser()));
            userActivity.setDate(ZonedDateTime.now());

            userActivity.setUserLanguages(
                    userLanguagesService.getUserLanguagesById(userActivityDto.getUserLanguages().getIdUserLanguages()));
            userActivity.setXpGained(Constants.XP_GAINED_PER_ACTIVITY);

            userActivity.setActivityType(modelMapper.map(userActivityDto.getActivityType(), ActivityType.class));

            if (userActivity.getActivityType().getType().equals(ActivityEnum.LESSON.name())) {
                /*
                 * When the activity is a lesson add the id to the object
                 * that will persist in the database and save it in completed
                 * lessons if it's the first time taking this lesson
                 */
                userActivity.setIdLesson(userActivityDto.getIdLesson());
                this.userCompletedLessonsService.save(userActivity);
            }

            // Add xp
            userLevelUpdateDto = this.userLevelManager.addXP(userActivity.getUser().getIdUser(), 50);
            userActivity.setXpGained(50);

            // Save activity
            UserActivity createdUserActivity = this.userActivityService.save(userActivity);

            // Save activity results in review words
            createdUserActivity.setResults(userActivityDto.getResults().stream()
                    .map(resultDto -> modelMapper.map(resultDto,
                            ActivityResult.class))
                    .toList());
            this.userReviewWordsService.saveActivityResults(createdUserActivity);

        } catch (ActivityTypeException activityTypeException) {
            throw new ActivityTypeException(HttpStatus.INTERNAL_SERVER_ERROR,
                    List.of(activityTypeException.getMessage()));
        } catch (Exception e) {
            throw new UserActivityException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        return new ResponseEntity<>(userLevelUpdateDto, HttpStatus.OK);
    }

}
