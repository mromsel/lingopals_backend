package com.romsel.lingopals_backend.masters.profiles.infrastructure;

import lombok.Data;

/** @see com.romsel.lingopals_backend.masters.profiles.domain.Profile */
@Data
public class ProfileDto {

    private Integer idProfile;
    private String name;
}
