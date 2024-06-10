package com.romsel.lingopals_backend.words_related.semantic_categories.domain;

import java.util.ArrayList;
import java.util.List;

import com.romsel.lingopals_backend.images.domain.Image;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.names.SemanticCategoryName;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "semantic_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemanticCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_semantic_category")
    private Integer idSemanticCategory;

    @Column(name = "english_name")
    private String englishName;

    @JoinColumn(name = "image")
    @ManyToOne(targetEntity = Image.class, optional = true, fetch = FetchType.LAZY)
    private Image image;

    @OneToMany(mappedBy = "semanticCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<SemanticCategoryName> names = new ArrayList<>();

    @Transient
    private String nameInOriginLanguage;

    @Transient
    private String nameInTargetLanguage;

}
