package com.romsel.lingopals_backend.domain.repositories.words_related;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.domain.entities.words_related.Language;
import com.romsel.lingopals_backend.domain.entities.words_related.Word;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {

    List<Word> findByLanguage(Language language);

}
