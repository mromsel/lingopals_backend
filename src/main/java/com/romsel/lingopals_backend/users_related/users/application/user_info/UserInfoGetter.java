package com.romsel.lingopals_backend.users_related.users.application.user_info;

import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.configuration.jwt.JwtService;
import com.romsel.lingopals_backend.users_related.users.domain.user_info.UserInfo;
import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;
import com.romsel.lingopals_backend.users_related.users_languages.infrastructure.UserLanguagesService;
import com.romsel.lingopals_backend.users_related.users_progress.infrastructure.UserProgressDataService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserInfoGetter {

    private final UserService userService;
    private final UserProgressDataService userProgressDataService;
    private final UserLanguagesService userLanguagesService;

    private final JwtService jwtService;

    public UserInfo getMe(String token) {

        String username = jwtService.getUsernameFromToken(token);

        Long idUser = userService.getIdUserByUsername(username);

        if (idUser != null) {

            UserInfo userInfo = new UserInfo();

            userInfo.setUserProgressData(userProgressDataService.getUserProgressByUserID(idUser));
            userInfo.setUserLanguages(userLanguagesService.getUserLanguagesByUserID(idUser));
            return userInfo;
        }
        return null;
    }
}
