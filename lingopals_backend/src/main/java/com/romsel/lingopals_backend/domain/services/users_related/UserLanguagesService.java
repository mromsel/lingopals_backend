package com.romsel.lingopals_backend.domain.services.users_related;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.domain.entities.users_related.UserLanguages;
import com.romsel.lingopals_backend.domain.repositories.users_related.UserLanguagesRepository;

@Service
public class UserLanguagesService {

    @Autowired
    private UserLanguagesRepository userLanguagesRepository;

    @Autowired
    private UserService userService;

    public List<UserLanguages> getUserLanguagesByUserID(Long idUser) {
        return userLanguagesRepository.findByUser(userService.getUserByID(idUser));
    }

}
