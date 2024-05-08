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
import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;
import com.romsel.lingopals_backend.users_related.users_activity.domain.ActivityEnum;
import com.romsel.lingopals_backend.users_related.users_activity.domain.ActivityResult;
import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivity;
import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivityException;
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
    private UserReviewWordsService userReviewWordsService;

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

        try {
            userActivity.setUser(userService.getUserByID(userActivityDto.getIdUser()));
            userActivity.setDate(ZonedDateTime.now());

            String activity = userActivityDto.getType();

            if (checkIfActivityExist(activity)) {
                userActivity.setType(activity);
                if (activity.equals(ActivityEnum.LESSON.name())) {
                    userActivity.setIdLesson(userActivityDto.getIdLesson());
                }
            }

            userActivity.setXpGained(Constants.XP_GAINED_PER_ACTIVITY);

            userActivity.setResults(userActivityDto.getResults().stream()
                    .map(resultDto -> modelMapper.map(resultDto, ActivityResult.class)).toList());
            this.userReviewWordsService.saveActivityResults(userActivity);

            this.userActivityService.save(userActivity);
        } catch (Exception e) {
            throw new UserActivityException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public boolean checkIfActivityExist(String activity) {
        return List.of(ActivityEnum.values())
                .stream()
                .map(Enum::name)
                .anyMatch(act -> act.equals(activity));
    }
}
