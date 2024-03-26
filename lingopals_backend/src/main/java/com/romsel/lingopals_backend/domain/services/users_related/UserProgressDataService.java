package com.romsel.lingopals_backend.domain.services.users_related;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.domain.entities.users_related.UserProgressData;
import com.romsel.lingopals_backend.domain.repositories.users_related.UserProgressDataRepository;

@Service
public class UserProgressDataService {

    @Autowired
    private UserProgressDataRepository userProgressDataRepository;

    @Autowired
    private UserService userService;

    public List<UserProgressData> getAllUserProgressData() {
        return (List<UserProgressData>) userProgressDataRepository.findAll();
    }

    public UserProgressData getUserProgressByUserID(Long idUser) {
        return userProgressDataRepository.findByUser(userService.getUserByID(idUser));
    }
}
