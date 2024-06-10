package com.romsel.lingopals_backend.words_related.word_references.infrastructure;

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

import com.romsel.lingopals_backend.words_related.word_references.domain.WordReference;
import com.romsel.lingopals_backend.words_related.word_references.domain.WordReferenceException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class WordReferenceController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WordReferenceService wordReferenceService;

    @GetMapping("word-references")
    public List<WordReferenceFullDto> getAllWordReferences() {
        return wordReferenceService.getAllWordReferences()
                .stream()
                .map(WordReferenceFullDto::mapToDto)
                .toList();
    }

    @GetMapping("word-references/{idWordReference}")
    public ResponseEntity<WordReferenceDto> getWordReferenceByID(@PathVariable Integer idWordReference) {
        WordReference wordReference;

        try {
            wordReference = wordReferenceService.getWordReferenceByID(idWordReference);
        } catch (DataAccessException e) {
            throw new WordReferenceException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        WordReferenceDto wordReferenceDto = modelMapper.map(wordReference, WordReferenceDto.class);

        return new ResponseEntity<>(wordReferenceDto, HttpStatus.OK);
    }

    @PostMapping("word-references")
    public ResponseEntity<?> create(@RequestBody WordReferenceFullDto wordReferenceDto) {

        wordReferenceDto.setIdWordRef(null);
        // wordReferenceDto.setCategory(null);
        WordReference wordReference = wordReferenceService.save(modelMapper.map(wordReferenceDto, WordReference.class));

        return new ResponseEntity<>(modelMapper.map(wordReference, WordReferenceFullDto.class), HttpStatus.OK);
    }

}
