package com.romsel.lingopals_backend.domain.repositories.users_related;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.domain.entities.users_related.UserReviewWords;
import com.romsel.lingopals_backend.domain.entities.users_related.idclass.UserReviewWordsIdClass;

@Repository
public interface UserReviewWordsRepository extends CrudRepository<UserReviewWords, UserReviewWordsIdClass> {

    List<UserReviewWords> findByIdUser(Long idUser);

    List<UserReviewWords> findByIdUserAndIdWordReferenceIn(Long idUser, List<Long> idsWordReferences);

    @Query("SELECT urw FROM UserReviewWords urw " +
            "WHERE urw.idUser = :idUser " +
            "ORDER BY urw.difficulty, urw.lastReviewDate DESC")
    List<UserReviewWords> findByIdUserOrderByDifficultyAscDateDesc(Long idUser);
}
