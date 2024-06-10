package com.romsel.lingopals_backend.words_related.semantic_categories.domain.names;

import com.romsel.lingopals_backend.masters.languages.domain.Language;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "semantic_categories_names")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemanticCategoryName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_semantic_category_name")
    private Integer idSemanticCategoryName;

    @ManyToOne
    @JoinColumn(name = "id_semantic_category")
    private SemanticCategory semanticCategory;

    @ManyToOne
    @JoinColumn(name = "id_language")
    private Language language;

    private String name;
}
