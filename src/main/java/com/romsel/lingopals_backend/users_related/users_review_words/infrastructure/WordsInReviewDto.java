package com.romsel.lingopals_backend.users_related.users_review_words.infrastructure;

import com.romsel.lingopals_backend.words_related.words.infrastructure.WordDto;

import lombok.Data;

@Data
public class WordsInReviewDto {

    private WordDto wordOrigin;
    private WordDto wordTarget;

}
