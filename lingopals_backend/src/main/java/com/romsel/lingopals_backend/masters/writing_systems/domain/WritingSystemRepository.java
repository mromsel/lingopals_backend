package com.romsel.lingopals_backend.masters.writing_systems.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WritingSystemRepository extends CrudRepository<WritingSystem, Integer> {

}
