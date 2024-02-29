package com.romsel.lingopal_backend.domain.entities.languages_content;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column(name = "flag")
    private String flag;

    @JoinColumn(name = "id_writing_system", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WritingSystem writingSystem;
}
