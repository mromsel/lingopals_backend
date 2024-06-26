package com.romsel.lingopals_backend.users_related.users.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.users_related.users.domain.User;
import com.romsel.lingopals_backend.users_related.users.domain.UserException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

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
}
