package com.romsel.lingopals_backend.masters.characters.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.masters.characters.domain.Character;
import com.romsel.lingopals_backend.masters.characters.domain.CharacterRepository;
import com.romsel.lingopals_backend.masters.writing_systems.domain.WritingSystem;

@Service
public class CharacterGetterByWritingSystemAndOrdered {
    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> findByWritingSystem(WritingSystem writingSystem) {
        return characterRepository.findByWritingSystemOrdered(writingSystem);
    }
}
