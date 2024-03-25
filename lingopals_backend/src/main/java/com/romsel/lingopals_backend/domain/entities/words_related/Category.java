package com.romsel.lingopals_backend.domain.entities.words_related;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @Column(name = "id_category")
    private Integer idCategory;

    @OneToOne(optional = false)
    @JoinColumn(name = "word_reference_name")
    private WordReference nameWordReference;

}
