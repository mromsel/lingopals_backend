package com.romsel.lingopals_backend.auth.infrastructure.signup;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.auth.application.AuthResponse;
import com.romsel.lingopals_backend.auth.application.signup.SignUpRequest;
import com.romsel.lingopals_backend.common.Constants;
import com.romsel.lingopals_backend.configuration.jwt.JwtService;
import com.romsel.lingopals_backend.masters.languages.infrastructure.LanguageService;
import com.romsel.lingopals_backend.masters.profiles.infrastructure.ProfileService;
import com.romsel.lingopals_backend.masters.xp_levels.infrastructure.XPLevelService;
import com.romsel.lingopals_backend.users_related.users.domain.User;
import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;
import com.romsel.lingopals_backend.users_related.users_progress.domain.UserProgressData;
import com.romsel.lingopals_backend.users_related.users_progress.infrastructure.UserProgressDataService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignUpService {

        private final UserService userService;

        private final UserProgressDataService userProgressDataService;

        private final LanguageService languageService;

        private final ProfileService profileService;

        private final XPLevelService xpLevelService;

        private final JwtService jwtService;

        private final PasswordEncoder passwordEncoder;

        public AuthResponse signUp(SignUpRequest request) {
                User user = User.builder()
                                .username(request.getUsername())
                                .email(request.getEmail())
                                .passwordHash(passwordEncoder.encode(request.getPassword()))
                                .preferredLanguage(languageService.getLanguageByID(request.getIdPreferredLanguage()))
                                .timeZone(request.getTimeZone())
                                .profile(profileService.findByName(Constants.PROFILE_USER_STANDARD))
                                .registrationDate(
                                                ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(request.getTimeZone())))
                                .build();

                User createdUser = userService.save(user);

                UserProgressData newUserProgressData = UserProgressData
                                .builder()
                                .idUserProgressData(createdUser.getIdUser())
                                .user(createdUser)
                                .coins(0)
                                .currentStreak(0)
                                .xpPoints(0L)
                                .xpLevel(xpLevelService.findByLevel(1))
                                .build();

                UserProgressData progressData = userProgressDataService.save(newUserProgressData);
                createdUser.setUserProgressData(progressData);
                userService.save(user);

                return AuthResponse.builder()
                                .token(jwtService.getToken(user))
                                .build();
        }
}
