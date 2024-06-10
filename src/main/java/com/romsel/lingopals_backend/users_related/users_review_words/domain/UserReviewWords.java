package com.romsel.lingopals_backend.users_related.users_review_words.domain;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_review_words")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserReviewWordsIdClass.class)
public class UserReviewWords {

    @Id
    @Column(name = "id_word_ref", nullable = false, updatable = false)
    private Long idWordReference;

    @Id
    @Column(name = "id_user_languages", nullable = false)
    private Long idUserLanguages;

    @Column(name = "difficulty")
    private Integer difficulty;

    @Column(name = "last_review_date")
    private ZonedDateTime lastReviewDate;
}
