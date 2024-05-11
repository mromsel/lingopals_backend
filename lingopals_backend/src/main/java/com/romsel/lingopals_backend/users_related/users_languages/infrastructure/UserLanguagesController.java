package com.romsel.lingopals_backend.users_related.users_languages.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class UserLanguagesController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserLanguagesService userLanguagesService;

    @GetMapping("/users-languages")
    public List<UserLanguagesDto> getAllUserLanguages() {
        return userLanguagesService.getAllUserLanguages()
                .stream()
                .map(userLanguage -> modelMapper.map(userLanguage, UserLanguagesDto.class))
                .toList();
    }

    @GetMapping("/users-languages/{idUser}")
    public List<UserLanguagesDto> getUserLanguages(@PathVariable Long idUser) {
        return userLanguagesService.getUserLanguagesByUserID(idUser)
                .stream()
                .map(userLanguage -> modelMapper.map(userLanguage, UserLanguagesDto.class))
                .toList();
    }

    @PostMapping("/users-languages/change-preferred")
    public ResponseEntity<?> changePreferredUserLanguages(@RequestBody UserLanguagesDto userLanguagesDto) {

        this.userLanguagesService.changePreferredUserLanguages(userLanguagesDto.getIdUser(),
                userLanguagesDto.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
