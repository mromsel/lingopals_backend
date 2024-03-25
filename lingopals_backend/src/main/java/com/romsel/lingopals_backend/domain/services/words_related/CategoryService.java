package com.romsel.lingopals_backend.domain.services.words_related;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.application.exceptions.words_related.CategoryException;
import com.romsel.lingopals_backend.domain.entities.words_related.Category;
import com.romsel.lingopals_backend.domain.repositories.words_related.CategoryRepository;

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
