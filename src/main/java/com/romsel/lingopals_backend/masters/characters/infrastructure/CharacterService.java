package com.romsel.lingopals_backend.masters.characters.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.masters.characters.domain.Character;
import com.romsel.lingopals_backend.masters.characters.domain.CharacterRepository;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> findAll() {
        return (List<Character>) characterRepository.findAll();
    }

}
