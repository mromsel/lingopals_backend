package com.romsel.lingopals_backend.masters.writing_systems.infrastructure;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.masters.writing_systems.domain.WritingSystem
 */
@Data
public class WritingSystemDto {

    private Integer idWritingSystem;
    private String name;
    private String isoCode;

}
