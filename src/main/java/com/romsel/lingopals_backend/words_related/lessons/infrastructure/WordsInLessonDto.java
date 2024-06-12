package com.romsel.lingopals_backend.words_related.lessons.infrastructure;

import com.romsel.lingopals_backend.words_related.words.infrastructure.WordDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WordsInLessonDto {

    private WordDto wordOrigin;
    private WordDto wordTarget;

    public static WordsInLessonDto convertToDto(WordDto wordOrigin, WordDto wordTarget) {
        if (wordOrigin != null && wordTarget != null) {
            return WordsInLessonDto.builder()
                    .wordOrigin(wordOrigin)
                    .wordTarget(wordTarget)
                    .build();
        } else {
            return null;
        }
    }

}
