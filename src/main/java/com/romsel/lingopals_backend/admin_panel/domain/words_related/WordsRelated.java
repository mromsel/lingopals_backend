package com.romsel.lingopals_backend.admin_panel.domain.words_related;

import java.util.List;

import com.romsel.lingopals_backend.words_related.categories.domain.Category;
import com.romsel.lingopals_backend.words_related.lessons.domain.Lesson;
import com.romsel.lingopals_backend.words_related.word_references.domain.WordReference;

import lombok.Data;

@Data
public class WordsRelated {
    List<Category> categories;
    List<Lesson> lessons;
    List<WordReference> wordReferences;
}
