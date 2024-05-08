package com.romsel.lingopals_backend.words_related.word_references.infrastructure;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.words_related.word_references.domain.WordReference;
import com.romsel.lingopals_backend.words_related.word_references.domain.WordReferenceException;
import com.romsel.lingopals_backend.words_related.word_references.domain.WordReferenceRepository;

@Service
public class WordReferenceService {

    @Autowired
    private WordReferenceRepository wordReferenceRepository;

    public List<WordReference> getAllWordReferences() {
        return (List<WordReference>) wordReferenceRepository.findAll();
    }

    public WordReference getWordReferenceByID(long idWordRef) {
        return wordReferenceRepository.findById(idWordRef)
                .orElseThrow(() -> new WordReferenceException(HttpStatus.NOT_FOUND,
                        List.of(ExceptionMessages.WORD_REFERENCE_NOT_FOUND)));
    }

    public List<WordReference> getAllWordReferencesByID(List<Long> idWordRefs) {
        return (List<WordReference>) wordReferenceRepository.findAllById(idWordRefs);
    }

}
