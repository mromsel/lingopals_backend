package com.romsel.lingopals_backend.masters.xp_levels.infrastructure;

import lombok.Data;

/** @see com.romsel.lingopals_backend.masters.xp_levels.domain.XPLevel */
@Data
public class XPLevelDto {

    private Integer levelNumber;
    private Integer xpRangeStart;
    private Integer xpRangeEnd;
    private Boolean hasMedal;

}
