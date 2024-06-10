package com.romsel.lingopals_backend.users_related.users_completed_lessons.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/users-lessons/{idUserLanguages}")
    public List<UserCompletedLessonsDto> getAllUserLessonsByUserID(@PathVariable Long idUserLanguages) {
        return userCompletedLessonsService.getAllUserLessonsByIdUserLanguages(idUserLanguages)
                .stream()
                .map(userCompletedLessons -> modelMapper.map(userCompletedLessons, UserCompletedLessonsDto.class))
                .toList();
    }
}
