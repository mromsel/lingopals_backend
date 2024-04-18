package com.romsel.lingopals_backend.domain.entities.users_related.idclass;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

/**
 * @see com.romsel.lingopals_backend.domain.entities.users_related.UserLanguages
 */
@EqualsAndHashCode
public class UserLanguagesIdClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long user;
    private Integer languageTarget;

}
