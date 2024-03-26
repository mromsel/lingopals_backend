package com.romsel.lingopals_backend.domain.repositories.users_related;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopals_backend.domain.entities.users_related.User;
import com.romsel.lingopals_backend.domain.entities.users_related.UserProgressData;

@Repository
public interface UserProgressDataRepository extends CrudRepository<UserProgressData, Long> {

    UserProgressData findByUser(User user);

}
