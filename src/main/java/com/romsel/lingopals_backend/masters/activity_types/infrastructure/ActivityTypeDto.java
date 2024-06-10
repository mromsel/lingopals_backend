package com.romsel.lingopals_backend.masters.activity_types.infrastructure;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.masters.activity_types.domain.ActivityType
 */
@Data
public class ActivityTypeDto {

    private Integer idActivityType;
    private String type;
}
