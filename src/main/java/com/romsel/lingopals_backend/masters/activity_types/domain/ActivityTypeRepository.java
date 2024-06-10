package com.romsel.lingopals_backend.masters.activity_types.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityTypeRepository extends CrudRepository<ActivityType, Integer> {

    Optional<ActivityType> findByType(String type);
}
