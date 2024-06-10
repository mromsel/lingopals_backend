package com.romsel.lingopals_backend.admin_panel.infrastructure.words_related;

import java.util.List;

import com.romsel.lingopals_backend.words_related.categories.infrastructure.CategoryDto;
import com.romsel.lingopals_backend.words_related.lessons.infrastructure.LessonDto;
import com.romsel.lingopals_backend.words_related.word_references.infrastructure.WordReferenceFullDto;

import lombok.Data;

@Data
public class WordsRelatedDto {
    private List<CategoryDto> categories;
    private List<LessonDto> lessons;
    private List<WordReferenceFullDto> wordReferences;
}
