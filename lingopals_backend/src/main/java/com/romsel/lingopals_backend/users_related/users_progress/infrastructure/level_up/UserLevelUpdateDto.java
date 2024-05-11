package com.romsel.lingopals_backend.users_related.users_progress.infrastructure.level_up;

import com.romsel.lingopals_backend.masters.xp_levels.domain.XPLevel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLevelUpdateDto {

    private Long initialXP;
    private Integer xpGained;
    private Boolean isLevelUp;
    private XPLevel newLevel;
}
