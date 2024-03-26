package com.romsel.lingopals_backend.domain.repositories.users_related;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.domain.entities.users_related.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
