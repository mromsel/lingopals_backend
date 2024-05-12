package com.romsel.lingopals_backend.users_related.users_progress.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserProgressDataController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserProgressDataService userProgressDataService;

    @GetMapping("/users-progress")
    public List<UserProgressDataDto> getAllUsersProgress() {
        return userProgressDataService.getAllUserProgressData()
                .stream()
                .map(userProgress -> modelMapper.map(userProgress, UserProgressDataDto.class))
                .toList();
    }

    @GetMapping("/users-progress/{idUser}")
    public UserProgressDataDto getUserProgressByUserID(@PathVariable Long idUser) {
        UserProgressDataDto userProgressDataDto = modelMapper
                .map(userProgressDataService.getUserProgressByUserID(idUser), UserProgressDataDto.class);
        return userProgressDataDto;
    }

}
