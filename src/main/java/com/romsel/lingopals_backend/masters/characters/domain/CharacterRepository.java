package com.romsel.lingopals_backend.masters.characters.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.romsel.lingopals_backend.masters.writing_systems.domain.WritingSystem;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Integer> {

    @Query("SELECT c FROM Character c WHERE c.writingSystem = :writingSystem ORDER BY c.alphabetOrder ASC, c.subOrder ASC")
    List<Character> findByWritingSystemOrdered(@Param("writingSystem") WritingSystem writingSystem);

}
