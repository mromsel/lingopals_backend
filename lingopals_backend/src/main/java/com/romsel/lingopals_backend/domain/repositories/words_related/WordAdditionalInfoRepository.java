package com.romsel.lingopals_backend.domain.repositories.words_related;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.domain.entities.words_related.Word;
import com.romsel.lingopals_backend.domain.entities.words_related.WordAdditionalInfo;

@Repository
public interface WordAdditionalInfoRepository extends CrudRepository<WordAdditionalInfo, Long> {

    WordAdditionalInfo findByWord(Word word);
}
