package com.romsel.lingopals_backend.masters.profiles.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.masters.profiles.domain.Profile;
import com.romsel.lingopals_backend.masters.profiles.domain.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> findAll() {
        return (List<Profile>) profileRepository.findAll();
    }
}
