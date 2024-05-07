package com.romsel.lingopals_backend.application.response.users_related;

import java.time.ZonedDateTime;
import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.users_related.UserActivity
 */
@Data
public class UserActivityDto {

    private Long idUserActivity;
    private Long idUser;
    private ZonedDateTime date;
    private String type;
    private Integer idLesson;
    private Integer xpGained;

}
