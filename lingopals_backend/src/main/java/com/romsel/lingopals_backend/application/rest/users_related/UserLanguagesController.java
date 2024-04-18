package com.romsel.lingopals_backend.application.rest.users_related;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.application.response.users_related.UserLanguagesDto;
import com.romsel.lingopals_backend.domain.services.users_related.UserLanguagesService;

@RestController
@RequestMapping("/api")
public class UserLanguagesController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserLanguagesService userLanguagesService;

    @GetMapping("/users-languages/{idUser}")
    public List<UserLanguagesDto> getUserLanguages(@PathVariable Long idUser) {
        return userLanguagesService.getUserLanguagesByUserID(idUser)
                .stream()
                .map(userLanguage -> modelMapper.map(userLanguage, UserLanguagesDto.class))
                .toList();
    }
}
