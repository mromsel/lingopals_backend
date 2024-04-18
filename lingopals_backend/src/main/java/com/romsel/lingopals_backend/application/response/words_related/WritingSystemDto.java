package com.romsel.lingopals_backend.application.response.words_related;

import lombok.Data;

/**
 * @see com.romsel.lingopals_backend.domain.entities.words_related.WritingSystem
 */
@Data
public class WritingSystemDto {

    private Integer idWritingSystem;
    private String name;
    private String isoCode;

}
