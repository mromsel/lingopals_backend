package com.romsel.lingopals_backend.application.response.users_related;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.application.response.users_related.UserActivityDto
 */
@Data
public class ActivityResultDto {

    private Long idWordRef;
    private Boolean result;

}
