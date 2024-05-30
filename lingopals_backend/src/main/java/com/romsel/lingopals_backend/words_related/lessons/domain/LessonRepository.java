package com.romsel.lingopals_backend.words_related.lessons.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Integer> {

    List<Lesson> findByLanguageLevel(LanguageLevel languageLevel);
}
