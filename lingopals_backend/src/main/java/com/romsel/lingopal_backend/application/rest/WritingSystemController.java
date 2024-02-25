package com.romsel.lingopal_backend.application.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopal_backend.application.exceptions.WritingSystemException;
import com.romsel.lingopal_backend.domain.entities.languages_content.WritingSystem;
import com.romsel.lingopal_backend.domain.services.WritingSystemService;

@RestController
@RequestMapping("/api")
public class WritingSystemController {

    @Autowired
    private WritingSystemService writingSystemService;

    @GetMapping("writing-systems")
    public List<WritingSystem> getAllWritingSystems() {
        return writingSystemService.getAllWritingSystems();
    }

    @GetMapping("writing-systems/{idWritingSystem}")
    public ResponseEntity<WritingSystem> getWritingSystemByID(@PathVariable int idWritingSystem) {
        WritingSystem writingSystem;

        try {
            writingSystem = writingSystemService.getWritingSystemByID(idWritingSystem);
        } catch (DataAccessException e) {
            throw new WritingSystemException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        return new ResponseEntity<>(writingSystem, HttpStatus.OK);
    }

}
