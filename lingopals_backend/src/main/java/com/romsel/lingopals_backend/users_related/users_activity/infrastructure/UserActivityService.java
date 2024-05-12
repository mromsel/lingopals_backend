package com.romsel.lingopals_backend.users_related.users_activity.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;
import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivity;
import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivityRepository;

@Service
public class UserActivityService {

    @Autowired
    private UserActivityRepository userActivityRepository;

    @Autowired
    private UserService userService;

    public List<UserActivity> getAllUsersActivities() {
        return (List<UserActivity>) userActivityRepository.findAll();
    }

    public List<UserActivity> getUserActivityByUserID(Long idUser) {
        return userActivityRepository.findByUser(userService.getUserByID(idUser));
    }

    public UserActivity save(UserActivity userActivity) {
        return userActivityRepository.save(userActivity);
    }

}
