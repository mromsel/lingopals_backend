package com.romsel.lingopals_backend.users_related.users_languages.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguagesRepository;

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
