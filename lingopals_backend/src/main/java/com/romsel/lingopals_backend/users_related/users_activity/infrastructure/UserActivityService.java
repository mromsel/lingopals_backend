package com.romsel.lingopals_backend.users_related.users_activity.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivity;
import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivityRepository;
import com.romsel.lingopals_backend.users_related.users_languages.infrastructure.UserLanguagesService;

@Service
public class UserActivityService {

    @Autowired
    private UserActivityRepository userActivityRepository;

    @Autowired
    private UserLanguagesService userLanguagesService;

    public List<UserActivity> getAllUsersActivities() {
        return (List<UserActivity>) userActivityRepository.findAll();
    }

    public List<UserActivity> getUserActivityByUserLanguages(Long idUserLanguages) {
        return userActivityRepository.findByUserLanguages(userLanguagesService.getUserLanguagesById(idUserLanguages));
    }

    public UserActivity save(UserActivity userActivity) {
        return userActivityRepository.save(userActivity);
    }

}
