package com.romsel.lingopals_backend.masters.characters.infrastructure;

import lombok.Data;

/** @see com.romsel.lingopals_backend.masters.characters.domain.Character */
@Data
public class CharacterDto {

    private Integer idCharacter;
    private String symbol;
    private Integer alphabetOrder;
    private Integer subOrder;
    private String type;
    private String romanization;
    private Integer idWritingSystem;
    // private WritingSystemDto writingSystem;

}
