package com.romsel.lingopals_backend.auth.infrastructure.signup;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.auth.application.AuthResponse;
import com.romsel.lingopals_backend.auth.application.signup.SignUpRequest;
import com.romsel.lingopals_backend.configuration.jwt.JwtService;
import com.romsel.lingopals_backend.masters.languages.infrastructure.LanguageService;
import com.romsel.lingopals_backend.users_related.users.domain.User;
import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserService userService;

    private final LanguageService languageService;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    public AuthResponse signUp(SignUpRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .preferredLanguage(languageService.getLanguageByID(request.getIdPreferredLanguage()))
                .timeZone(request.getTimeZone())
                .profile(null) // TODO: ADD PROFILE
                .registrationDate(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(request.getTimeZone())))
                .build();

        User createdUser = userService.save(user);

        // TODO: CREATE PROGRESS DATA

        System.out.println(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

}
