package com.romsel.lingopals_backend.domain.services.users_related;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.domain.entities.users_related.UserActivity;
import com.romsel.lingopals_backend.domain.repositories.users_related.UserActivityRepository;

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

}
