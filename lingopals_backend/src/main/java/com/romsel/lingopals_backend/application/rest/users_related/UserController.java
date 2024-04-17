package com.romsel.lingopals_backend.application.rest.users_related;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.application.exceptions.auth.LoginException;
import com.romsel.lingopals_backend.application.exceptions.users_related.UserException;
import com.romsel.lingopals_backend.application.response.users_related.LoginSuccessDto;
import com.romsel.lingopals_backend.application.response.users_related.UserBasicDto;
import com.romsel.lingopals_backend.application.response.users_related.UserLoginDto;
import com.romsel.lingopals_backend.application.response.users_related.UserSignUpDto;
import com.romsel.lingopals_backend.domain.entities.users_related.User;
import com.romsel.lingopals_backend.domain.entities.users_related.UserProgressData;
import com.romsel.lingopals_backend.domain.services.users_related.UserProgressDataService;
import com.romsel.lingopals_backend.domain.services.users_related.UserService;
import com.romsel.lingopals_backend.domain.services.words_related.LanguageService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserProgressDataService userProgressDataService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public List<UserBasicDto> getAllUsers(@RequestParam String param) {
        // TODO: COMPROBACIÓN DE ADMIN

        return userService.getAllUsers()
                .stream()
                .map(user -> modelMapper.map(user, UserBasicDto.class))
                .toList();
    }

    @GetMapping("/users/{idUser}")
    public ResponseEntity<UserBasicDto> getUserByID(@PathVariable Long idUser) {
        User user;

        try {
            user = userService.getUserByID(idUser);
        } catch (DataAccessException e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        UserBasicDto userBasicDto = modelMapper.map(user, UserBasicDto.class);

        return new ResponseEntity<>(userBasicDto, HttpStatus.OK);
    }

    @PostMapping("/users/signup")
    public ResponseEntity<UserBasicDto> signUpUser(@RequestBody UserSignUpDto userReceived) {
        User newUser = new User();

        User userCreated = null;
        UserProgressData userProgressDataCreated = null;

        try {
            newUser.setUsername(userReceived.getUsername());
            newUser.setEmail(userReceived.getEmail());
            String passwordHash = passwordEncoder.encode(userReceived.getPassword());
            newUser.setPasswordHash(passwordHash);
            newUser.setRegistrationDate(ZonedDateTime.now(ZoneId.of(userReceived.getTimeZone())));
            newUser.setPreferredLanguage(languageService.getLanguageByID(userReceived.getIdPreferredLanguage()));
            newUser.setTimeZone(userReceived.getTimeZone());
            newUser.setUserProgressData(null);

            userCreated = userService.save(newUser);

            UserProgressData userProgressData = new UserProgressData();
            userProgressData.setCoins(0);
            userProgressData.setCurrentStreak(0);
            userProgressData.setMaxStreak(0);
            userProgressData.setUser(userCreated);

            userProgressDataCreated = userProgressDataService.save(userProgressData);

            userCreated.setUserProgressData(userProgressDataCreated);

            userCreated = userService.save(userCreated);

        } catch (DataAccessException e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR,
                    List.of(ExceptionMessages.USER_CREATE_ERROR, e.getMessage()));
        }

        UserBasicDto userBasicDto = modelMapper.map(userCreated, UserBasicDto.class);

        return new ResponseEntity<>(userBasicDto, HttpStatus.CREATED);
    }

    @PostMapping("/users/login")
    public ResponseEntity<LoginSuccessDto> login(@RequestBody UserLoginDto userReceived) {
        User user;
        try {
            user = userService.getUserByNameOrEmail(userReceived.getUsernameOrEmail());
        } catch (UserException e) {
            throw new LoginException(List.of(ExceptionMessages.LOGIN_FAILED));
        } catch (DataAccessException e2) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR,
                    List.of(e2.getMessage(), e2.getLocalizedMessage()));
        }

        if (user != null && (passwordEncoder.matches(userReceived.getPassword(), user.getPasswordHash()))) {
            LoginSuccessDto loginSuccessDto = new LoginSuccessDto();
            loginSuccessDto.setIdUser(user.getIdUser());
            String token = "This is the Token";
            loginSuccessDto.setToken(token);
            return new ResponseEntity<>(loginSuccessDto, HttpStatus.OK);
        }

        throw new LoginException(List.of(ExceptionMessages.LOGIN_FAILED));
    }

}
