package com.romsel.lingopals_backend.masters.writing_systems.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "writing_system")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WritingSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_writing_system")
    private Integer idWritingSystem;

    @Column(name = "name", unique = true)
    private String name;

    // ISO 15924
    @Column(name = "iso_code", unique = true)
    private String isoCode;

}
