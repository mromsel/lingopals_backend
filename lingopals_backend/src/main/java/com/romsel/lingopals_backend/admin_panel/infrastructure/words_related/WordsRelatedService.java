package com.romsel.lingopals_backend.admin_panel.infrastructure.words_related;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.admin_panel.domain.words_related.WordsRelated;
import com.romsel.lingopals_backend.words_related.categories.infrastructure.CategoryService;
import com.romsel.lingopals_backend.words_related.lessons.infrastructure.LessonService;
import com.romsel.lingopals_backend.words_related.word_references.infrastructure.WordReferenceService;

@Service
public class WordsRelatedService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private WordReferenceService wordReferenceService;

    public WordsRelated getWordsRelated() {
        WordsRelated response = new WordsRelated();

        response.setCategories(categoryService.getAllCategories());
        response.setLessons(lessonService.getAllLessons());
        response.setWordReferences(wordReferenceService.getAllWordReferences());

        return response;
    }
}
