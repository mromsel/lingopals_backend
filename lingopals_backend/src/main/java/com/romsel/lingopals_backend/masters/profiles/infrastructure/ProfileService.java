package com.romsel.lingopals_backend.masters.profiles.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.masters.profiles.domain.Profile;
import com.romsel.lingopals_backend.masters.profiles.domain.ProfileException;
import com.romsel.lingopals_backend.masters.profiles.domain.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> findAll() {
        return (List<Profile>) profileRepository.findAll();
    }

    public Profile findByName(String name) {
        return profileRepository.findByName(name).orElseThrow(
                () -> new ProfileException(HttpStatus.NOT_FOUND, List.of(ExceptionMessages.PROFILE_NOT_FOUND)));
    }
}
