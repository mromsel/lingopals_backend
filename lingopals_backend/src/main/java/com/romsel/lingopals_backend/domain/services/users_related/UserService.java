package com.romsel.lingopals_backend.domain.services.users_related;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.application.exceptions.users_related.UserException;
import com.romsel.lingopals_backend.domain.entities.users_related.User;
import com.romsel.lingopals_backend.domain.repositories.users_related.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserByID(Long idUser) {
        return userRepository.findById(idUser)
                .orElseThrow(
                        () -> new UserException(HttpStatus.NOT_FOUND, List.of(ExceptionMessages.USER_NOT_FOUND)));
    }

    public User getUserByNameOrEmail(String usernameOrEmail) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail)
                .orElseThrow(
                        () -> new UserException(HttpStatus.NOT_FOUND, List.of(ExceptionMessages.USER_NOT_FOUND)));
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
