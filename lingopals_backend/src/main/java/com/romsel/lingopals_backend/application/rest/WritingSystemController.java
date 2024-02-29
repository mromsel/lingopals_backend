package com.romsel.lingopals_backend.application.rest;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.application.exceptions.WritingSystemException;
import com.romsel.lingopals_backend.application.response.WritingSystemDto;
import com.romsel.lingopals_backend.domain.entities.languages_content.WritingSystem;
import com.romsel.lingopals_backend.domain.services.WritingSystemService;

@RestController
@RequestMapping("/api")
public class WritingSystemController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WritingSystemService writingSystemService;

    @GetMapping("writing-systems")
    public List<WritingSystemDto> getAllWritingSystems() {
        return writingSystemService.getAllWritingSystems()
                .stream()
                .map(writingSystem -> modelMapper.map(writingSystem, WritingSystemDto.class))
                .toList();
    }

    @GetMapping("writing-systems/{idWritingSystem}")
    public ResponseEntity<WritingSystemDto> getWritingSystemByID(@PathVariable int idWritingSystem) {
        WritingSystem writingSystem;

        try {
            writingSystem = writingSystemService.getWritingSystemByID(idWritingSystem);
        } catch (DataAccessException e) {
            throw new WritingSystemException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        WritingSystemDto writingSystemDto = modelMapper.map(writingSystem, WritingSystemDto.class);

        return new ResponseEntity<>(writingSystemDto, HttpStatus.OK);
    }

}
