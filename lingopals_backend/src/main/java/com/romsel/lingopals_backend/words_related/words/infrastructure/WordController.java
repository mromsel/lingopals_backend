package com.romsel.lingopals_backend.words_related.words.infrastructure;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.romsel.lingopals_backend.words_related.words.domain.Word;

public interface WordController<E extends Word, ID extends Serializable> {
    public ResponseEntity<?> getAll();

    public ResponseEntity<?> getOne(@PathVariable ID id);

    public ResponseEntity<?> getOneByWordRef(@PathVariable Long idWordRef);

    public ResponseEntity<?> getAllById(@RequestBody List<Long> ids);

    public ResponseEntity<?> getAllByIdWordReferences(@RequestBody List<Long> idsWordReferences);

    public ResponseEntity<?> getAllWordStringFilter(@PathVariable String filter);

    public ResponseEntity<?> save(@RequestBody E entity);

    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);

    public ResponseEntity<?> delete(@PathVariable ID id);
}
