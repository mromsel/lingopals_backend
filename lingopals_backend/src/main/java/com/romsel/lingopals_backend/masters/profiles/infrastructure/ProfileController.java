package com.romsel.lingopals_backend.masters.profiles.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profiles")
    public List<ProfileDto> getAllProfiles() {
        return profileService.findAll()
                .stream()
                .map(profile -> modelMapper.map(profile, ProfileDto.class))
                .toList();
    }
}
