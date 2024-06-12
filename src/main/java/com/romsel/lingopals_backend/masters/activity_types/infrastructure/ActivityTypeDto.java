package com.romsel.lingopals_backend.masters.activity_types.infrastructure;

import com.romsel.lingopals_backend.masters.activity_types.domain.ActivityType;

import lombok.Builder;
import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.masters.activity_types.domain.ActivityType
 */
@Data
@Builder
public class ActivityTypeDto {

    private Integer idActivityType;
    private String type;

    public static ActivityTypeDto convertToDto(ActivityType activityType) {
        if (activityType != null) {
            return ActivityTypeDto.builder()
                    .idActivityType(activityType.getIdActivityType())
                    .type(activityType.getType())
                    .build();
        } else {
            return null;
        }
    }
}
