package com.romsel.lingopals_backend.users_related.users_activity.infrastructure;

import java.time.ZonedDateTime;
import java.util.List;

import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeDto;
import com.romsel.lingopals_backend.users_related.users_languages.infrastructure.UserLanguagesDto;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivity
 */
@Data
public class UserActivityDto {

    private Long idUserActivity;
    private Long idUser;
    private UserLanguagesDto userLanguages;
    private ZonedDateTime date;
    private ActivityTypeDto activityType;
    private Integer idLesson;
    private Integer xpGained;
    private List<ActivityResultDto> results;

}
