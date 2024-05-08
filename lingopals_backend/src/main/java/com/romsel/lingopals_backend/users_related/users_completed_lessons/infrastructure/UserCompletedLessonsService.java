package com.romsel.lingopals_backend.users_related.users_completed_lessons.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessons;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessonsRepository;

@Service
public class UserCompletedLessonsService {

    @Autowired
    private UserCompletedLessonsRepository userCompletedLessonsRepository;

    @Autowired
    private UserService userService;

    public List<UserCompletedLessons> getAllUserCompletedLessons() {
        return (List<UserCompletedLessons>) userCompletedLessonsRepository.findAll();
    }

    public List<UserCompletedLessons> getAllUserLessonsByUserID(Long idUser) {
        return userCompletedLessonsRepository.findByUser(userService.getUserByID(idUser));
    }

}
