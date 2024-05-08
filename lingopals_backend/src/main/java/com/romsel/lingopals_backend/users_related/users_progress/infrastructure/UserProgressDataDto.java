package com.romsel.lingopals_backend.users_related.users_progress.infrastructure;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.users_related.users.infrastructure.UserBasicDto;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.users_related.users_progress.domain.UserProgressData
 */
@Data
public class UserProgressDataDto {

    private Long idUserProgressData;
    private UserBasicDto user;
    private Integer coins;
    private Integer currentStreak;
    private ZonedDateTime streakStartDate;
    private ZonedDateTime streakEndDate;
    private Integer maxStreak;
    private Long xpPoints;

}
