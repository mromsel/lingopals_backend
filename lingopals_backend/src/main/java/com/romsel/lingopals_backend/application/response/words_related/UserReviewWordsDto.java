package com.romsel.lingopals_backend.application.response.words_related;

import java.util.List;

import lombok.Data;

@Data
public class UserReviewWordsDto {

    private LanguageLevelDto languageLevel;
    private List<WordsInReviewDto> wordsList;

}
