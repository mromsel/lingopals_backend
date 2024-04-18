package com.romsel.lingopals_backend.domain.repositories.users_related;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.domain.entities.users_related.User;
import com.romsel.lingopals_backend.domain.entities.users_related.UserLanguages;
import com.romsel.lingopals_backend.domain.entities.users_related.idclass.UserLanguagesIdClass;
import java.util.List;

@Repository
public interface UserLanguagesRepository extends CrudRepository<UserLanguages, UserLanguagesIdClass> {

    List<UserLanguages> findByUser(User user);

}
