package com.romsel.lingopals_backend.users_related.users_completed_lessons.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.users_related.users.domain.User;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;

import java.util.List;

@Repository
public interface UserCompletedLessonsRepository extends CrudRepository<UserCompletedLessons, Long> {

    List<UserCompletedLessons> findByUser(User user);

    UserCompletedLessons findByLessonAndUser(Lesson lesson, User user);

}
