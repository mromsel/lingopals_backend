package com.romsel.lingopals_backend.application.response.users_related;

import java.time.ZonedDateTime;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.users_related.UserProgressData
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

}
