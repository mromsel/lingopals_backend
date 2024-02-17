package com.romsel.lingopal_backend.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.romsel.lingopal_backend.domain.entities.languages_content.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    
}
