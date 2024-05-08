package com.romsel.lingopals_backend.users_related.users_progress.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;
import com.romsel.lingopals_backend.users_related.users_progress.domain.UserProgressData;
import com.romsel.lingopals_backend.users_related.users_progress.domain.UserProgressDataRepository;

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

    public UserProgressData save(UserProgressData userProgressData) {
        return userProgressDataRepository.save(userProgressData);
    }

}
