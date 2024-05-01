package com.romsel.lingopals_backend.domain.services.words_related.words;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;

import com.romsel.lingopals_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.application.exceptions.words_related.WordException;
import com.romsel.lingopals_backend.domain.entities.words_related.WordReference;
import com.romsel.lingopals_backend.domain.entities.words_related.words.Word;
import com.romsel.lingopals_backend.domain.repositories.words_related.words.WordRepository;
import com.romsel.lingopals_backend.domain.services.words_related.WordReferenceService;

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

    // @Override
    // public E findByIdWordReference(Long idWordReference) {
    // try {
    // E entity = wordRepository.findByIdWordReference(idWordReference);
    // if (entity != null) {
    // return entity;
    // } else {
    // throw new WordException(HttpStatus.NOT_FOUND,
    // List.of(ExceptionMessages.WORD_NOT_FOUND));
    // }
    // } catch (DataAccessException e) {
    // throw new WordException(HttpStatus.INTERNAL_SERVER_ERROR,
    // List.of(e.getMessage()));
    // }
    // }

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
