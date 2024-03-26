package com.romsel.lingopals_backend.application.rest.users_related;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.application.response.users_related.UserActivityDto;
import com.romsel.lingopals_backend.domain.services.users_related.UserActivityService;

@RestController
@RequestMapping("/api")
public class UserActivityController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserActivityService userActivityService;

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
}
