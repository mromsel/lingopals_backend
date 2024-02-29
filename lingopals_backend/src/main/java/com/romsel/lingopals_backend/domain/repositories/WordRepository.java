package com.romsel.lingopals_backend.domain.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.domain.entities.languages_content.Language;
import com.romsel.lingopals_backend.domain.entities.languages_content.Word;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {

    List<Word> findByLanguage(Language language);

}
