package com.romsel.lingopals_backend.images.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.images.domain.Image;
import com.romsel.lingopals_backend.images.domain.ImageException;
import com.romsel.lingopals_backend.images.domain.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> findAll() {
        return (List<Image>) imageRepository.findAll();
    }

    public Image findById(Long idImage) {
        return imageRepository.findById(idImage)
                .orElseThrow(() -> new ImageException(HttpStatus.NOT_FOUND, List.of("Image not found")));
    }
}
