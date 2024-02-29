package com.romsel.lingopals_backend.application.response;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.languages_content.WritingSystem
 */
@Data
public class WritingSystemDto {

    private Integer idWritingSystem;
    private String name;
    private String isoCode;

}
