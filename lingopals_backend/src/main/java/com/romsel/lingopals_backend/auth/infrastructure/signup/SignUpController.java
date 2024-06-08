package com.romsel.lingopals_backend.auth.infrastructure.signup;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.auth.application.AuthResponse;
import com.romsel.lingopals_backend.auth.application.signup.SignUpRequest;
import com.romsel.lingopals_backend.auth.domain.signup.SignUpException;
import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.users_related.users.domain.User;
import com.romsel.lingopals_backend.users_related.users.infrastructure.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    private final UserService userService;

    @PostMapping("/auth/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest request) {
        List<User> usersConflictList = this.userService.getUsersByNameOrEmail(request.getUsername(),
                request.getEmail());

        if (!usersConflictList.isEmpty()) {
            boolean isUsernameConflict = usersConflictList.stream()
                    .anyMatch(user -> user.getUsername().equals(request.getUsername()));

            String message = "";
            if (isUsernameConflict) {
                message = ExceptionMessages.USER_USERNAME_CONFLICT;
            } else {
                message = ExceptionMessages.USER_EMAIL_CONFLICT;
            }

            throw new SignUpException(HttpStatus.CONFLICT, List.of(message));
        }

        try {
            AuthResponse token = signUpService.signUp(request);

            return ResponseEntity.ok().build();
        } catch (DataAccessException e) {
            throw new SignUpException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }
    }
}
