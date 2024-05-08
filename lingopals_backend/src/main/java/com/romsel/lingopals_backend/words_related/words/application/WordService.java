package com.romsel.lingopals_backend.words_related.words.application;

import java.io.Serializable;
import java.util.List;

import com.romsel.lingopals_backend.words_related.words.domain.Word;

public interface WordService<E extends Word, ID extends Serializable> {

    public List<E> findAll();

    public E findById(ID id);

    public E findByWordReference(Long idWordReference);

    public List<E> findAllById(List<ID> ids);

    public List<E> findByWordReferenceIn(List<Long> idsWordReferences);

    public List<E> findByWordStringContaining(String filter);

    public E save(E entity);

    public E update(ID id, E entity);

    public boolean delete(ID id);
}
