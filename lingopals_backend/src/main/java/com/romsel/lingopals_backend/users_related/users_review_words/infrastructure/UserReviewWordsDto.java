package com.romsel.lingopals_backend.users_related.users_review_words.infrastructure;

import java.util.List;

import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;

import lombok.Data;

@Data
public class UserReviewWordsDto {

    private LanguageLevelDto languageLevel;
    private List<WordsInReviewDto> wordsList;

}
