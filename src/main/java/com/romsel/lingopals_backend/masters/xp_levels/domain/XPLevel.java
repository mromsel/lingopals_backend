package com.romsel.lingopals_backend.masters.xp_levels.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "xp_levels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XPLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_number")
    private Integer levelNumber;

    @Column(name = "xp_range_start")
    private Integer xpRangeStart;

    @Column(name = "xp_range_end")
    private Integer xpRangeEnd;

    @Column(name = "has_medal")
    private Boolean hasMedal;
}
