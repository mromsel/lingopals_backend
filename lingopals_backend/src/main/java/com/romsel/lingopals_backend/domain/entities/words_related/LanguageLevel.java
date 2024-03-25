package com.romsel.lingopals_backend.domain.entities.words_related;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "language_levels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageLevel {

    @Id
    @Column(name = "id_level")
    private Integer idLevel;

    @Column(name = "level_name")
    private String levelName;
}
