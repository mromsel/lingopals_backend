package com.romsel.lingopals_backend.users_related.users_review_words.domain;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

/**
 * @see com.romsel.lingopals_backend.users_related.users_review_words.domain.UserReviewWords
 */
@EqualsAndHashCode
public class UserReviewWordsIdClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idWordReference;
    private Long idUserLanguages;
}
