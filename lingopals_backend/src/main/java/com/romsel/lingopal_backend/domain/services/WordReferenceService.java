package com.romsel.lingopal_backend.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopal_backend.domain.entities.languages_content.WordReference;
import com.romsel.lingopal_backend.domain.repositories.WordReferenceRepository;

@Service
public class WordReferenceService {

    @Autowired
    private WordReferenceRepository wordReferenceRepository;

    public List<WordReference> getAllWordReferences() {
        return (List<WordReference>) wordReferenceRepository.findAll();
    }

    public Optional<WordReference> getWordReferenceByID(long idWordRef) {
        return wordReferenceRepository.findById(idWordRef);
    }

    public List<WordReference> getAllWordReferencesByID(List<Long> idWordRefs) {
        return (List<WordReference>) wordReferenceRepository.findAllById(idWordRefs);
    }
    
}
