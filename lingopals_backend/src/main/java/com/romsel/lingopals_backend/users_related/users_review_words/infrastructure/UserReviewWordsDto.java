package com.romsel.lingopals_backend.users_related.users_review_words.infrastructure;

import java.util.List;

import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeDto;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.users_related.users_review_words.domain.UserReviewWords
 */
@Data
public class UserReviewWordsDto {

    private LanguageLevelDto languageLevel;
    private Long idUserLanguages;
    private ActivityTypeDto activityType;
    private List<WordsInReviewDto> wordsList;

}
