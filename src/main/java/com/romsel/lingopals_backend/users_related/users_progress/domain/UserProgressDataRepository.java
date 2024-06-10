package com.romsel.lingopals_backend.users_related.users_progress.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.users_related.users.domain.User;

@Repository
public interface UserProgressDataRepository extends CrudRepository<UserProgressData, Long> {

    UserProgressData findByUser(User user);

}
