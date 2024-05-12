package com.romsel.lingopals_backend.users_related.users_languages.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.users_related.users.domain.User;
import com.romsel.lingopals_backend.users_related.users.domain.UserException;
import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguagesException;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguagesRepository;

@Service
public class UserLanguagesService {

    @Autowired
    private UserLanguagesRepository userLanguagesRepository;

    @Autowired
    private UserService userService;

    public List<UserLanguages> getAllUserLanguages() {
        return (List<UserLanguages>) userLanguagesRepository.findAll();
    }

    public List<UserLanguages> getUserLanguagesByUserID(Long idUser) {
        return userLanguagesRepository.findByUser(userService.getUserByID(idUser));
    }

    public UserLanguages getUserLanguagesById(Long idUserLanguages) {
        return userLanguagesRepository.findById(idUserLanguages)
                .orElseThrow(() -> new UserLanguagesException(HttpStatus.NOT_FOUND,
                        List.of(ExceptionMessages.USER_LANGUAGES_NOT_FOUND)));
    }

    public void changePreferredUserLanguages(Long idUser, Long idUserLanguages) {
        try {
            User user = userService.getUserByID(idUser);

            user.setPreferredUserLanguages(getUserLanguagesById(idUserLanguages));
            userService.save(user);
        } catch (UserException | UserLanguagesException e) {
            throw new UserLanguagesException(HttpStatus.NOT_FOUND, List.of(e.getMessage()));
        } catch (DataAccessException e2) {
            throw new UserLanguagesException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e2.getMessage()));
        }

    }
}
