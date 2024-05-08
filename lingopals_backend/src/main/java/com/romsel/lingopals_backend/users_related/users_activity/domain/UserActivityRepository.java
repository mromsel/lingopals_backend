package com.romsel.lingopals_backend.users_related.users_activity.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.users_related.users.domain.User;

import java.util.List;

@Repository
public interface UserActivityRepository extends CrudRepository<UserActivity, Long> {

    List<UserActivity> findByUser(User user);

}
