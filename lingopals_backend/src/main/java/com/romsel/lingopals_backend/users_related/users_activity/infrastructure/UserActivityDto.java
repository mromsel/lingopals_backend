package com.romsel.lingopals_backend.users_related.users_activity.infrastructure;

import java.time.ZonedDateTime;
import java.util.List;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivity
 */
@Data
public class UserActivityDto {

    private Long idUserActivity;
    private Long idUser;
    private ZonedDateTime date;
    private String type;
    private Integer idLesson;
    private Integer xpGained;
    private List<ActivityResultDto> results;

}
