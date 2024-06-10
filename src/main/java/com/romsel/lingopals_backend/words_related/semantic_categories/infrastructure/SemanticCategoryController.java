package com.romsel.lingopals_backend.words_related.semantic_categories.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class SemanticCategoryController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SemanticCategoryService semanticCategoryService;

    @GetMapping("/semantic-categories")
    public List<SemanticCategoryDto> getAllSemanticCategories() {
        return semanticCategoryService.findAll().stream()
                .map(semanticCategory -> modelMapper.map(semanticCategory, SemanticCategoryDto.class)).toList();
    }

}
