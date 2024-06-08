package com.romsel.lingopals_backend.users_related.users_languages.domain;

import java.time.ZonedDateTime;
import java.util.List;

import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel;
import com.romsel.lingopals_backend.masters.languages.domain.Language;
import com.romsel.lingopals_backend.users_related.users.domain.User;
import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLanguages {

    @Id
    @GeneratedValue
    @Column(name = "id_user_languages")
    private Long idUserLanguages;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "preferred")
    private boolean preferred;

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

    @OneToMany(mappedBy = "userLanguages", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<UserActivity> userActivities;
}
