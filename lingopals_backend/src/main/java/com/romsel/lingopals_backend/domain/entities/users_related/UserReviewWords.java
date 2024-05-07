package com.romsel.lingopals_backend.domain.entities.users_related;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.domain.entities.users_related.idclass.UserReviewWordsIdClass;

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
    @Column(name = "id_user", nullable = false, updatable = false)
    private Long idUser;

    @Id
    @Column(name = "id_word_ref", nullable = false, updatable = false)
    private Long idWordReference;

    @Column(name = "difficulty")
    private Integer difficulty;

    @Column(name = "last_review_date")
    private ZonedDateTime lastReviewDate;
}
