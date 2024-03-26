package com.romsel.lingopals_backend.domain.repositories.users_related;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.domain.entities.users_related.User;
import com.romsel.lingopals_backend.domain.entities.users_related.UserCompletedLessons;
import java.util.List;

@Repository
public interface UserCompletedLessonsRepository extends CrudRepository<UserCompletedLessons, Long> {

    List<UserCompletedLessons> findByUser(User user);

}
