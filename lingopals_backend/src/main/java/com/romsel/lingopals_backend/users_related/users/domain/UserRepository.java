package com.romsel.lingopals_backend.users_related.users.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.username = :userNameOrEmail " +
            "OR u.email = :userNameOrEmail")
    Optional<User> findByUsernameOrEmail(String userNameOrEmail);

    Optional<User> findByUsername(String username);
}
