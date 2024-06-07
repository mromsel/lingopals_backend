package com.romsel.lingopals_backend.admin_panel.infrastructure.words_related;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.admin_panel.domain.words_related.WordsRelated;
import com.romsel.lingopals_backend.words_related.categories.infrastructure.CategoryService;
import com.romsel.lingopals_backend.words_related.lessons.infrastructure.LessonService;
import com.romsel.lingopals_backend.words_related.word_references.infrastructure.WordReferenceService;

@Service
public class WordsRelatedService {

    private CategoryService categoryService;

    private LessonService lessonService;

    private WordReferenceService wordReferenceService;

    public WordsRelatedService(CategoryService categoryService, @Lazy LessonService lessonService,
            WordReferenceService wordReferenceService) {
        this.categoryService = categoryService;
        this.lessonService = lessonService;
        this.wordReferenceService = wordReferenceService;
    }

    public WordsRelated getWordsRelated() {
        WordsRelated response = new WordsRelated();

        response.setCategories(categoryService.getAllCategories());
        response.setLessons(lessonService.getAllLessons());
        response.setWordReferences(wordReferenceService.getAllWordReferences());

        return response;
    }
}
