package com.romsel.lingopals_backend.application.response.users_related;

import java.time.ZonedDateTime;

import com.romsel.lingopals_backend.domain.entities.elements.Activity;
import com.romsel.lingopals_backend.domain.entities.users_related.User;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.users_related.UserActivity
 */
@Data
public class UserActivityDto {

    private Long idUserActivity;
    private User user;
    private ZonedDateTime date;
    private Activity type;

}
