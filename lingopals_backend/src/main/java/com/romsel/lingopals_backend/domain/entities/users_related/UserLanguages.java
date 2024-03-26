package com.romsel.lingopals_backend.domain.entities.users_related;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.domain.entities.users_related.idclass.UserLanguagesIdClass;
import com.romsel.lingopals_backend.domain.entities.words_related.Language;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @see com.romsel.lingopals_backend.domain.entities.users_related.idclass.UserLanguagesIdClass
 */
@Entity
@Table(name = "users_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserLanguagesIdClass.class)
public class UserLanguages {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "language_target")
    private Language languageTarget;

    @ManyToOne
    @JoinColumn(name = "language_origin")
    private Language languageOrigin;

    @Column(name = "start_date")
    private ZonedDateTime startDate;

}
