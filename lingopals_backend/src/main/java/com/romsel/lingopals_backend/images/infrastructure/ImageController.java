package com.romsel.lingopals_backend.images.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class ImageController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ImageService imageService;

    @GetMapping("/images")
    public List<ImageDto> getAll() {
        return imageService.findAll()
                .stream()
                .map(image -> modelMapper.map(image, ImageDto.class))
                .toList();
    }

    @GetMapping("/images/{idImage}")
    public ImageDto getImageById(@PathVariable Long idImage) {
        return modelMapper.map(imageService.findById(idImage), ImageDto.class);
    }

}
