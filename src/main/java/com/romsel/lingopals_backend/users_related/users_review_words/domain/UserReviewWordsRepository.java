package com.romsel.lingopals_backend.users_related.users_review_words.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReviewWordsRepository extends CrudRepository<UserReviewWords, UserReviewWordsIdClass> {

    List<UserReviewWords> findByIdUserLanguages(Long idUserLanguages);

    List<UserReviewWords> findByIdUserLanguagesAndIdWordReferenceIn(Long idUserLanguages, List<Long> idsWordReferences);

    @Query("SELECT urw FROM UserReviewWords urw " +
            "WHERE urw.idUserLanguages = :idUserLanguages " +
            "ORDER BY urw.difficulty, urw.lastReviewDate DESC")
    List<UserReviewWords> findByIdUserLanguagesOrderByDifficultyAscDateDesc(Long idUserLanguages);
}
