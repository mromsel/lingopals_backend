package com.romsel.lingopals_backend.users_related.users_languages.application.change_preferred;

import java.util.List;

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
public class UserLanguagesChangePreferredService {

    private UserLanguagesRepository userLanguagesRepository;

    private UserService userService;

    public UserLanguagesChangePreferredService(UserLanguagesRepository userLanguagesRepository,
            UserService userService) {
        this.userLanguagesRepository = userLanguagesRepository;
        this.userService = userService;
    }

    public void changePreferredUserLanguages(Long idUser, Long idUserLanguages) {
        try {
            // Get the user
            User user = userService.getUserByID(idUser);

            // Get the current preferred UserLanguages
            UserLanguages currentPreferred = user.getUserLanguages()
                    .stream()
                    .filter(UserLanguages::isPreferred)
                    .findFirst()
                    .orElse(null);

            // Get the new UserLanguages to be set as preferred
            UserLanguages newPreferred = user.getUserLanguages()
                    .stream()
                    .filter(ul -> ul.getIdUserLanguages().equals(idUserLanguages))
                    .findFirst()
                    .orElseThrow(() -> new UserLanguagesException(HttpStatus.NOT_FOUND,
                            List.of(ExceptionMessages.USER_LANGUAGES_NOT_FOUND)));

            // If the new UserLanguages is different from the current one
            if (currentPreferred == null
                    || !currentPreferred.getIdUserLanguages().equals(newPreferred.getIdUserLanguages())) {
                // If there is a current preferred UserLanguages, set its preferred status to
                // false
                if (currentPreferred != null) {
                    currentPreferred.setPreferred(false);
                    userLanguagesRepository.save(currentPreferred);
                }

                // Set the new UserLanguages as preferred
                newPreferred.setPreferred(true);
                userLanguagesRepository.save(newPreferred);
            }
        } catch (UserException | UserLanguagesException e) {
            throw new UserLanguagesException(HttpStatus.NOT_FOUND, List.of(e.getMessage()));
        } catch (DataAccessException e2) {
            throw new UserLanguagesException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e2.getMessage()));
        }
    }
}
