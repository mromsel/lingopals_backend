package com.romsel.lingopals_backend.users_related.users_progress.domain;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.masters.xp_levels.domain.XPLevel;
import com.romsel.lingopals_backend.users_related.users.domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users_progress_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProgressData {

    @Id
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

    @Column(name = "max_streak")
    private Integer maxStreak;

    @Column(name = "xp_points")
    private Long xpPoints;

    @ManyToOne
    @JoinColumn(name = "xp_level")
    private XPLevel xpLevel;

}
