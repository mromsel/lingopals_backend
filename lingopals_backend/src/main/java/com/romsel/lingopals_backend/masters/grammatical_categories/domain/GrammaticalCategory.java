package com.romsel.lingopals_backend.masters.grammatical_categories.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grammatical_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrammaticalCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grammatical_category")
    private Integer idGrammaticalCategory;

    @Column(name = "name")
    private String name;

}
