package com.romsel.lingopals_backend.words_related.words.infrastructure;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;

import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.words_related.word_references.domain.WordReference;
import com.romsel.lingopals_backend.words_related.word_references.infrastructure.WordReferenceService;
import com.romsel.lingopals_backend.words_related.words.application.WordService;
import com.romsel.lingopals_backend.words_related.words.domain.Word;
import com.romsel.lingopals_backend.words_related.words.domain.WordException;
import com.romsel.lingopals_backend.words_related.words.domain.WordRepository;

public abstract class WordServiceImpl<E extends Word, ID extends Serializable> implements WordService<E, ID> {

    protected WordRepository<E, ID> wordRepository;

    @Autowired
    private WordReferenceService wordReferenceService;

    public WordServiceImpl(WordRepository<E, ID> wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public List<E> findAll() {
        try {
            return (List<E>) wordRepository.findAll();
        } catch (DataAccessException e) {
            throw new WordException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }
    }

    @Override
    public E findById(ID id) {
        try {
            return wordRepository.findById(id).orElseThrow(
                    () -> new WordException(HttpStatus.NOT_FOUND, List.of(ExceptionMessages.WORD_NOT_FOUND)));
        } catch (DataAccessException e) {
            throw new WordException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }
    }

    @Override
    public E findByWordReference(Long idWordReference) {
        try {
            WordReference wordRef = wordReferenceService.getWordReferenceByID(idWordReference);
            E entity = wordRepository.findByWordReference(wordRef);
            if (entity != null) {
                return entity;
            } else {
                throw new WordException(HttpStatus.NOT_FOUND,
                        List.of(ExceptionMessages.WORD_NOT_FOUND));
            }
        } catch (DataAccessException e) {
            throw new WordException(HttpStatus.INTERNAL_SERVER_ERROR,
                    List.of(e.getMessage()));
        }
    }

    @Override
    public List<E> findAllById(List<ID> ids) {
        return (List<E>) wordRepository.findAllById(ids);
    }

    @Override
    public List<E> findByWordReferenceIn(List<Long> idsWordReferences) {
        try {
            List<WordReference> wordRefs = wordReferenceService.getAllWordReferencesByID(idsWordReferences);
            List<E> entities = wordRepository.findByWordReferenceIn(wordRefs);
            if (entities != null && !entities.isEmpty()) {
            }
            return entities;
            // else {
            // throw new WordException(HttpStatus.NOT_FOUND,
            // List.of(ExceptionMessages.WORD_NOT_FOUND));
            // }
        } catch (DataAccessException e) {
            throw new WordException(HttpStatus.INTERNAL_SERVER_ERROR,
                    List.of(e.getMessage()));
        }
    }

    @Override
    public List<E> findByWordStringContaining(String filter) {
        try {
            return wordRepository.findByWordStringContaining(filter);
        } catch (DataAccessException e) {
            throw new WordException(HttpStatus.INTERNAL_SERVER_ERROR,
                    List.of(e.getMessage()));
        }
    }

    @Override
    public E save(E entity) {
        try {
            return wordRepository.save(entity);
        } catch (DataAccessException e) {
            throw new WordException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }
    }

    @Override
    public E update(ID id, E entity) {
        try {
            // TODO: ????
            E entityUpdate = wordRepository.findById(id).get();
            entityUpdate = wordRepository.save(entity);
            return entityUpdate;
        } catch (DataAccessException e) {
            throw new WordException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }
    }

    @Override
    public boolean delete(ID id) {
        try {
            if (wordRepository.existsById(id)) {
                wordRepository.deleteById(id);
                return true;
            } else {
                throw new WordException(HttpStatus.NOT_FOUND, List.of(ExceptionMessages.WORD_NOT_FOUND));
            }
        } catch (DataAccessException e) {
            throw new WordException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }
    }

}
