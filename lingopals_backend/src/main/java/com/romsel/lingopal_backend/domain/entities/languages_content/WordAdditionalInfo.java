package com.romsel.lingopal_backend.domain.entities.languages_content;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "words_additional_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WordAdditionalInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWordAdditionalInfo;

    @Column(name = "romanization")
    private String romanization;

    @Column(name = "pronunciation", nullable = false)
    private String pronunciation;

    @Column(name = "gramatical_category", nullable = false)
    private String gramaticalCategory; // verb, sustantive, adjective

    @Column(name = "gramatical_gender", nullable = false)
    private String gramaticalGender; // M, F, N

    @Column(name = "gender_variations")
    private List<String> genderVariations; // "F actriz", "M actor"

    @Column(name = "number_variations")
    private List<String> numberVariations; // "S árbol", "P árboles"

    @Column(name = "changes_on_gender", nullable = false)
    private Boolean changesOnGender;

    @Column(name = "changes_on_plural", nullable = false)
    private Boolean changesOnPlural;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_word", insertable = false, updatable = false)
    private Word word;
}