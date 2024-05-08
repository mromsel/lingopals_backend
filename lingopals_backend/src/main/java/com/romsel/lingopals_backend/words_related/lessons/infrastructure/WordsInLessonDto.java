package com.romsel.lingopals_backend.words_related.lessons.infrastructure;

import com.romsel.lingopals_backend.words_related.words.infrastructure.WordDto;

import lombok.Data;

@Data
public class WordsInLessonDto {

    private WordDto wordOrigin;
    private WordDto wordTarget;

}
