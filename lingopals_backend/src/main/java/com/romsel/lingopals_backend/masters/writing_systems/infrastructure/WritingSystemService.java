package com.romsel.lingopals_backend.masters.writing_systems.infrastructure;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.masters.writing_systems.domain.WritingSystem;
import com.romsel.lingopals_backend.masters.writing_systems.domain.WritingSystemException;
import com.romsel.lingopals_backend.masters.writing_systems.domain.WritingSystemRepository;

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
