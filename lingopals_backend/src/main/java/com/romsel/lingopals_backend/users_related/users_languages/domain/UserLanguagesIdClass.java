package com.romsel.lingopals_backend.users_related.users_languages.domain;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

/**
 * @see com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages
 */
@EqualsAndHashCode
public class UserLanguagesIdClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long user;
    private Integer languageTarget;

}
