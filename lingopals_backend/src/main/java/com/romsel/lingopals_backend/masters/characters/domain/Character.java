package com.romsel.lingopals_backend.masters.characters.domain;

import com.romsel.lingopals_backend.masters.writing_systems.domain.WritingSystem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "characters")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_character")
    private Integer idCharacter;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @Column(name = "alphabet_order")
    private Integer alphabetOrder;

    @Column(name = "sub_order")
    private Integer subOrder;

    @Column(name = "romanization")
    private String romanization;

    /**
     * @see com.romsel.lingopals_backend.masters.characters.domain.CharacterTypeEnum
     */
    @Column(name = "type")
    private String type; // 'VOWEL', 'CONSONANT', 'DIGIT'

    @JoinColumn(name = "id_writing_system", nullable = false)
    @ManyToOne(optional = false)
    private WritingSystem writingSystem;
}