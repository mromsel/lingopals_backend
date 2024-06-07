package com.romsel.lingopals_backend.users_related.users_completed_lessons.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;

import java.util.List;

@Repository
public interface UserCompletedLessonsRepository extends CrudRepository<UserCompletedLessons, Long> {

    List<UserCompletedLessons> findByUserLanguages(UserLanguages userLanguages);

    UserCompletedLessons findByLessonAndUserLanguages(Lesson lesson, UserLanguages userLanguages);

    @Query("SELECT ucl FROM UserCompletedLessons ucl " +
            "JOIN ucl.lesson l " +
            "WHERE ucl.userLanguages.idUserLanguages = :idUserLanguages " +
            "AND l.languageLevel.idLevel = :idLanguageLevel")
    List<UserCompletedLessons> findAllByLanguageLevelAndUserLanguages(Integer idLanguageLevel, Long idUserLanguages);

}
