package com.romsel.lingopals_backend.users_related.users_languages.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.users_related.users.domain.User;

import java.util.List;

@Repository
public interface UserLanguagesRepository extends CrudRepository<UserLanguages, Long> {

    List<UserLanguages> findByUser(User user);

}
