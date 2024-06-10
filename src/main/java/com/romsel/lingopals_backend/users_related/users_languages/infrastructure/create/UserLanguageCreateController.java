package com.romsel.lingopals_backend.users_related.users_languages.infrastructure.create;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.users_related.users_languages.application.create.UserLanguagesCreate;
import com.romsel.lingopals_backend.users_related.users_languages.application.create.UserLanguagesCreateService;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.users_related.users_languages.infrastructure.UserLanguagesDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class UserLanguageCreateController {

    private ModelMapper modelMapper;

    private UserLanguagesCreateService userLanguagesCreateService;

    public UserLanguageCreateController(ModelMapper modelMapper,
            UserLanguagesCreateService userLanguagesCreateService) {
        this.modelMapper = modelMapper;
        this.userLanguagesCreateService = userLanguagesCreateService;
    }

    @PostMapping("/users-languages")
    public ResponseEntity<List<UserLanguagesDto>> createUserLanguages(
            @RequestBody UserLanguagesCreateDto userLanguagesCreateDto) {

        List<UserLanguages> userLanguagesList = this.userLanguagesCreateService
                .createUserLanguages(modelMapper.map(userLanguagesCreateDto, UserLanguagesCreate.class));

        List<UserLanguagesDto> response = userLanguagesList
                .stream()
                .map(userLanguages -> modelMapper.map(userLanguages, UserLanguagesDto.class))
                .toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
