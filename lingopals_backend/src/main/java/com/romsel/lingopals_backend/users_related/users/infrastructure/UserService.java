package com.romsel.lingopals_backend.users_related.users.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.users_related.users.domain.User;
import com.romsel.lingopals_backend.users_related.users.domain.UserException;
import com.romsel.lingopals_backend.users_related.users.domain.UserRepository;

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
