package com.romsel.lingopals_backend.application.response.words_related;

import lombok.Data;

@Data
public class WordsInReviewDto {

    private WordDto wordOrigin;
    private WordDto wordTarget;

}
