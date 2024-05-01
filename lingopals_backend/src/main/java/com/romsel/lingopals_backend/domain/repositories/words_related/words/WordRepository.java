package com.romsel.lingopals_backend.domain.repositories.words_related.words;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.romsel.lingopals_backend.domain.entities.words_related.WordReference;
import com.romsel.lingopals_backend.domain.entities.words_related.words.Word;

@NoRepositoryBean
public interface WordRepository<E extends Word, ID extends Serializable> extends CrudRepository<E, ID> {

    E findByWordReference(WordReference wordReference);

    List<E> findByWordReferenceIn(List<WordReference> wordReferences);

    List<E> findByWordStringContaining(String filter);
}
