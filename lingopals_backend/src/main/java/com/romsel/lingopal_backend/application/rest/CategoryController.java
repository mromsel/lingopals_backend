package com.romsel.lingopal_backend.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopal_backend.application.exceptions.CategoryException;
import com.romsel.lingopal_backend.domain.entities.languages_content.Category;
import com.romsel.lingopal_backend.domain.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{idCategory}")
    public ResponseEntity<Category> getCategoryByID(@PathVariable Integer idCategory) {
        Category category;

        try {
            category = categoryService.getCategoryByID(idCategory);
        } catch (DataAccessException e) {
            throw new CategoryException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
