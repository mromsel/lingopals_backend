package com.romsel.lingopal_backend.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopal_backend.application.exceptions.CategoryException;
import com.romsel.lingopal_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopal_backend.domain.entities.languages_content.Category;
import com.romsel.lingopal_backend.domain.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category getCategoryByID(Integer idCategory) {
        return categoryRepository.findById(idCategory).orElseThrow(
                () -> new CategoryException(HttpStatus.NOT_FOUND, List.of(ExceptionMessages.CATEGORY_NOT_FOUND)));
    }

}
