package com.romsel.lingopals_backend.masters.grammatical_categories.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class GrammaticalCategoryController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GrammaticalCategoryService grammaticalCategoryService;

    @GetMapping("/grammatical-categories")
    public List<GrammaticalCategoryDto> getAllGrammaticalCategories() {
        return grammaticalCategoryService.findAll()
                .stream()
                .map(grammCategory -> modelMapper.map(grammCategory, GrammaticalCategoryDto.class))
                .toList();
    }

}
