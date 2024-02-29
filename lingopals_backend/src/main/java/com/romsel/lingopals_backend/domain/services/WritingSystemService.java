package com.romsel.lingopals_backend.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.application.exceptions.WritingSystemException;
import com.romsel.lingopals_backend.domain.entities.languages_content.WritingSystem;
import com.romsel.lingopals_backend.domain.repositories.WritingSystemRepository;

@Service
public class WritingSystemService {

    @Autowired
    private WritingSystemRepository writingSystemRepository;

    public List<WritingSystem> getAllWritingSystems() {
        return (List<WritingSystem>) writingSystemRepository.findAll();
    }

    public WritingSystem getWritingSystemByID(int idWritingSystem) {
        return writingSystemRepository.findById(idWritingSystem)
                .orElseThrow(() -> new WritingSystemException(HttpStatus.NOT_FOUND,
                        List.of(ExceptionMessages.WRITING_SYSTEM_NOT_FOUND)));
    }

}
