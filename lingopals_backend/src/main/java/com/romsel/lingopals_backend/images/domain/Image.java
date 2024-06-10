package com.romsel.lingopals_backend.images.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private Long idImage;

    @Column(name = "name")
    private String name;

    @Column(name = "image_base64", columnDefinition = "MEDIUMTEXT")
    private String imageBase64;

    @Column(name = "alt_text")
    private String altText;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private ImageTypeEnum type;

}
