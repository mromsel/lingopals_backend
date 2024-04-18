package com.romsel.lingopals_backend.domain.services.users_related;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.domain.entities.users_related.UserCompletedLessons;
import com.romsel.lingopals_backend.domain.repositories.users_related.UserCompletedLessonsRepository;

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
