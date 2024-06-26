package com.romsel.lingopals_backend.words_related.words.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.romsel.lingopals_backend.words_related.words.domain.Word;

public abstract class WordControllerImpl<E extends Word, S extends WordServiceImpl<E, Long>>
        implements WordController<E, Long> {

    @Autowired
    private S service;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<WordDto> list = service.findAll()
                .stream()
                .map(WordDto::convertToDto)
                .toList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    @GetMapping("/ids/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        WordDto wordDto = WordDto.convertToDto(service.findById(id));
        return new ResponseEntity<>(wordDto, HttpStatus.OK);
    }

    @Override
    @GetMapping("/refs/{idWordRef}")
    public ResponseEntity<?> getOneByWordRef(@PathVariable Long idWordRef) {
        WordDto wordDto = WordDto.convertToDto(service.findByWordReference(idWordRef));
        return new ResponseEntity<>(wordDto,
                HttpStatus.OK);
    }

    @Override
    @PostMapping("/ids")
    public ResponseEntity<?> getAllById(@RequestBody List<Long> ids) {
        List<WordDto> list = service.findAllById(ids)
                .stream()
                .map(WordDto::convertToDto)
                .toList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    @PostMapping("/refs")
    public ResponseEntity<?> getAllByIdWordReferences(@RequestBody List<Long> idsWordReferences) {
        List<WordDto> list = service.findByWordReferenceIn(idsWordReferences)
                .stream()
                .map(WordDto::convertToDto)
                .toList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    @GetMapping("/filter/{filter}")
    public ResponseEntity<?> getAllWordStringFilter(@PathVariable String filter) {
        List<WordDto> list = service.findByWordStringContaining(filter)
                .stream()
                .map(WordDto::convertToDto)
                .toList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity) {
        WordDto wordDto = WordDto.convertToDto(service.save(entity));
        return new ResponseEntity<>(wordDto, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity) {
        WordDto wordDto = WordDto.convertToDto(service.update(id, entity));
        return new ResponseEntity<>(wordDto, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}
