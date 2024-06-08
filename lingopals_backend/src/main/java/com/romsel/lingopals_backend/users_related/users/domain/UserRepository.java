package com.romsel.lingopals_backend.users_related.users.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.username = :username " +
            "OR u.email = :email")
    List<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);

    @Query("SELECT u.idUser " +
            "FROM User u " +
            "WHERE u.username = :username")
    Long findIdUserByUsername(String username);
}
