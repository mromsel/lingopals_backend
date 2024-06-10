package com.romsel.lingopals_backend.users_related.users_languages.application.create;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.users_related.users.domain.User;
import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;
import com.romsel.lingopals_backend.users_related.users_languages.application.change_preferred.UserLanguagesChangePreferredService;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguagesRepository;

@Service
public class UserLanguagesCreateService {

    private UserLanguagesRepository userLanguagesRepository;

    private UserService userService;

    private UserLanguagesChangePreferredService userLanguagesChangePreferredService;

    public UserLanguagesCreateService(UserLanguagesRepository userLanguagesRepository, UserService userService,
            UserLanguagesChangePreferredService userLanguagesChangePreferredService) {
        this.userLanguagesRepository = userLanguagesRepository;
        this.userService = userService;
        this.userLanguagesChangePreferredService = userLanguagesChangePreferredService;
    }

    public List<UserLanguages> createUserLanguages(UserLanguagesCreate userLanguagesCreate) {
        UserLanguages userLanguages = new UserLanguages();

        User user = userService.getUserByID(userLanguagesCreate.getIdUser());

        userLanguages.setUser(user);
        userLanguages.setLanguageOrigin(userLanguagesCreate.getLanguageOrigin());
        userLanguages.setLanguageTarget(userLanguagesCreate.getLanguageTarget());
        userLanguages.setPreferred(false);
        userLanguages.setStartDate(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(user.getTimeZone())));
        userLanguages.setLanguageLevel(userLanguagesCreate.getLanguageLevel());

        List<UserLanguages> currentUserLanguages = userLanguagesRepository.findByUser(user);
        if (currentUserLanguages.isEmpty()) {
            userLanguages.setPreferred(true);
        }

        UserLanguages userLanguagesSaved = this.userLanguagesRepository.save(userLanguages);

        if (!userLanguagesSaved.isPreferred() && userLanguagesCreate.getPreferred() != null
                && Boolean.TRUE.equals(userLanguagesCreate.getPreferred())) {
            this.userLanguagesChangePreferredService.changePreferredUserLanguages(user.getIdUser(),
                    userLanguagesSaved.getIdUserLanguages());
        }

        return userLanguagesRepository.findByUser(user);
    }

}
