package com.romsel.lingopals_backend.domain.entities.users_related.idclass;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

/**
 * @see com.romsel.lingopals_backend.domain.entities.users_related.UserReviewWords
 */
@EqualsAndHashCode
public class UserReviewWordsIdClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idUser;
    private Long idWordReference;
}
