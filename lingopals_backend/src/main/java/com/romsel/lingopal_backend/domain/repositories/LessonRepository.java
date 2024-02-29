package com.romsel.lingopal_backend.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romsel.lingopal_backend.domain.entities.languages_content.Lesson;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Integer> {

}
