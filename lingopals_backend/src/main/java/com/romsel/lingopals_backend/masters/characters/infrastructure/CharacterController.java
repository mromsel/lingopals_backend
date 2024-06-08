package com.romsel.lingopals_backend.masters.characters.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.masters.characters.application.CharacterGetterByWritingSystemAndOrdered;
import com.romsel.lingopals_backend.masters.writing_systems.infrastructure.WritingSystemService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class CharacterController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CharacterService characterService;

    @Autowired
    private CharacterGetterByWritingSystemAndOrdered characterGetterByWritingSystemAndOrdered;

    @Autowired
    private WritingSystemService writingSystemService;

    @GetMapping("/characters")
    public List<CharacterDto> getAll() {
        return characterService
                .findAll().stream()
                .map(character -> modelMapper.map(character, CharacterDto.class)).toList();
    }

    @GetMapping("/characters/{idWritingSystem}")
    public List<CharacterDto> getCharacterByWritingSystem(@PathVariable Integer idWritingSystem) {
        return characterGetterByWritingSystemAndOrdered
                .findByWritingSystem(writingSystemService.getWritingSystemByID(idWritingSystem)).stream()
                .map(character -> modelMapper.map(character, CharacterDto.class)).toList();
    }

}
