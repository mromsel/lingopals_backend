package com.romsel.lingopals_backend.application.rest.words_related;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.application.exceptions.words_related.CategoryException;
import com.romsel.lingopals_backend.application.response.words_related.CategoryDto;
import com.romsel.lingopals_backend.domain.entities.words_related.Category;
import com.romsel.lingopals_backend.domain.services.words_related.CategoryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories()
                .stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .toList();
    }

    @GetMapping("/categories/{idCategory}")
    public ResponseEntity<CategoryDto> getCategoryByID(@PathVariable Integer idCategory) {
        Category category;

        try {
            category = categoryService.getCategoryByID(idCategory);
        } catch (DataAccessException e) {
            throw new CategoryException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);

        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

}
