package com.romsel.lingopals_backend.images.infrastructure;

import com.romsel.lingopals_backend.images.domain.Image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
    private Long idImage;
    private String name;
    private String imageBase64;
    private String altText;
    private String type;

    public static ImageDto convertToDto(Image image) {
        if (image != null) {
            return ImageDto.builder()
                    .idImage(image.getIdImage())
                    .imageBase64(image.getImageBase64())
                    .altText(image.getAltText())
                    .build();
        } else {
            return null;
        }
    }
}
