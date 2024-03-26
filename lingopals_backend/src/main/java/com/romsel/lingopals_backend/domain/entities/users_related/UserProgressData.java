package com.romsel.lingopals_backend.domain.entities.users_related;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users_progress_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProgressData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_progress_data", nullable = false, updatable = false)
    private Long idUserProgressData;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", updatable = false)
    @ToString.Exclude
    private User user;

    @Column(name = "coins")
    private Integer coins;

    @Column(name = "current_streak")
    private Integer currentStreak;

    @Column(name = "streak_start_date")
    private ZonedDateTime streakStartDate;

    @Column(name = "streak_end_date")
    private ZonedDateTime streakEndDate;

    @Column(name = "max_streak") // al iniciar por defecto es 0
    private Integer maxStreak;

}
