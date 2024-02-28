package com.romsel.lingopal_backend.application.rest;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopal_backend.application.exceptions.CategoryException;
import com.romsel.lingopal_backend.application.response.CategoryDto;
import com.romsel.lingopal_backend.domain.entities.languages_content.Category;
import com.romsel.lingopal_backend.domain.services.CategoryService;
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
