package com.romsel.lingopals_backend.masters.profiles.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

    Optional<Profile> findByName(String name);

}
