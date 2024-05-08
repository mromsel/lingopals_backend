package com.romsel.lingopals_backend.users_related.users_languages.domain;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel;
import com.romsel.lingopals_backend.masters.languages.domain.Language;
import com.romsel.lingopals_backend.users_related.users.domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @see com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguagesIdClass
 */
@Entity
@Table(name = "users_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLanguages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user_languages")
    private Long idUserLanguages;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "language_target")
    private Language languageTarget;

    @ManyToOne
    @JoinColumn(name = "language_origin")
    private Language languageOrigin;

    @Column(name = "start_date")
    private ZonedDateTime startDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_language_level")
    private LanguageLevel languageLevel;
}
