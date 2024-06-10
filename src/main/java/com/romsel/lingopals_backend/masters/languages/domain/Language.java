package com.romsel.lingopals_backend.masters.languages.domain;

import com.romsel.lingopals_backend.images.domain.Image;
import com.romsel.lingopals_backend.masters.writing_systems.domain.WritingSystem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Language {

    @Id
    @Column(name = "id_language")
    private Integer idLanguage;

    @Column(name = "language_name")
    private String languageName;

    // ISO 639-1
    @Column(name = "iso_code")
    private String isoCode;

    @JoinColumn(name = "flag")
    @ManyToOne(targetEntity = Image.class, optional = true, fetch = FetchType.LAZY)
    private Image flag;

    @JoinColumn(name = "id_writing_system", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WritingSystem writingSystem;
}
