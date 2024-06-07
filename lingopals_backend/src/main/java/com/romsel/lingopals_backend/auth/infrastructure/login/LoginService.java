package com.romsel.lingopals_backend.auth.infrastructure.login;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.auth.application.AuthResponse;
import com.romsel.lingopals_backend.auth.application.login.LoginRequest;
import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.configuration.jwt.JwtService;
import com.romsel.lingopals_backend.users_related.users.domain.UserException;
import com.romsel.lingopals_backend.users_related.users.domain.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

        private final UserRepository userRepository;
        private final AuthenticationManager authenticationManager;
        private final JwtService jwtService;

        public AuthResponse login(LoginRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
                UserDetails user = userRepository.findByUsername(request.getUsername())
                                .orElseThrow(() -> new UserException(HttpStatus.NOT_FOUND,
                                                List.of(ExceptionMessages.USER_NOT_FOUND)));
                String token = jwtService.getToken(user);
                return AuthResponse.builder()
                                .token(token)
                                .build();
        }
}
