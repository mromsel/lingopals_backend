package com.romsel.lingopals_backend.application.rest.users_related;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.application.response.users_related.UserCompletedLessonsDto;
import com.romsel.lingopals_backend.domain.services.users_related.UserCompletedLessonsService;

@RestController
@RequestMapping("/api")
public class UserCompletedLessonsController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserCompletedLessonsService userCompletedLessonsService;

    @GetMapping("/users-lessons")
    public List<UserCompletedLessonsDto> getAllUserCompletedLessons() {
        return userCompletedLessonsService.getAllUserCompletedLessons()
                .stream()
                .map(userCompletedLessons -> modelMapper.map(userCompletedLessons, UserCompletedLessonsDto.class))
                .toList();
    }

    @GetMapping("/users-lessons/{idUser}")
    public List<UserCompletedLessonsDto> getAllUserLessonsByUserID(@PathVariable Long idUser) {
        return userCompletedLessonsService.getAllUserLessonsByUserID(idUser)
                .stream()
                .map(userCompletedLessons -> modelMapper.map(userCompletedLessons, UserCompletedLessonsDto.class))
                .toList();

    }

}
